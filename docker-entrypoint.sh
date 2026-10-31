#!/bin/bash
set -e

# Disable Tomcat shutdown port so Render port-scanner only connects to the HTTP port
sed -i 's/<Server port="8005"/<Server port="-1"/g' /usr/local/tomcat/conf/server.xml

# Configure dynamic HTTP port from Render ($PORT) and bind to 0.0.0.0
PORT_TO_USE="${PORT:-8080}"
echo "==> Configuring Tomcat HTTP port to $PORT_TO_USE and binding to 0.0.0.0"
sed -i "s/port=\"8080\"/port=\"$PORT_TO_USE\" address=\"0.0.0.0\"/g" /usr/local/tomcat/conf/server.xml

# Allow legacy TLS algorithms in Java 8 security policy if needed
for secfile in /usr/local/openjdk-8/jre/lib/security/java.security /usr/lib/jvm/*/jre/lib/security/java.security; do
  if [ -f "$secfile" ]; then
    sed -i 's/TLSv1, //g' "$secfile" 2>/dev/null || true
    sed -i 's/TLSv1.1, //g' "$secfile" 2>/dev/null || true
  fi
done

# Safe memory settings for Render 512MB container (256MB heap + 128MB metaspace)
export CATALINA_OPTS="-Xms96m -Xmx256m -XX:MaxMetaspaceSize=128m -XX:+UseSerialGC -Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true -Djdk.tls.client.protocols=TLSv1.2,TLSv1.3"

# Configure database settings
PROP_DIR="/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/com/bul/zydex/property"
PROP_FILE="$PROP_DIR/jdbc.properties"

if [ -d "$PROP_DIR" ]; then
  echo "==> Configuring database settings..."
  FINAL_JDBC_URL="${JDBC_URL:-jdbc:mysql://localhost:3306/eprocsuite_chargezone}"
  if [[ "$FINAL_JDBC_URL" == *"useSSL=true"* ]] && [[ "$FINAL_JDBC_URL" != *"enabledTLSProtocols"* ]]; then
    FINAL_JDBC_URL="${FINAL_JDBC_URL}&enabledTLSProtocols=TLSv1.2"
  fi

  cat << EOF > "$PROP_FILE"
jdbc.database = ${JDBC_DATABASE:-eprocsuite_chargezone}
jdbc.driverClassName = com.mysql.jdbc.Driver
jdbc.url = $FINAL_JDBC_URL
jdbc.username = ${JDBC_USERNAME:-root}
jdbc.password = ${JDBC_PASSWORD:-root}
jdbc2.database = ${JDBC_DATABASE:-eprocsuite_chargezone}
jdbc2.driverClassName = com.mysql.jdbc.Driver
jdbc2.url = $FINAL_JDBC_URL
jdbc2.username = ${JDBC_USERNAME:-root}
jdbc2.password = ${JDBC_PASSWORD:-root}
EOF
  echo "==> Database properties configured successfully."
fi

# Ensure log directory exists
mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/logs

echo "==> Starting Apache Tomcat on port $PORT_TO_USE..."
exec "$@"
