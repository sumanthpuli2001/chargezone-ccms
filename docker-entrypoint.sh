#!/bin/bash
set -e

# Disable Tomcat shutdown port so Render port-scanner only connects to the HTTP port
sed -i 's/<Server port="8005"/<Server port="-1"/g' /usr/local/tomcat/conf/server.xml

# Configure dynamic HTTP port from Render ($PORT)
PORT_TO_USE="${PORT:-8080}"
echo "==> Configuring Tomcat HTTP port to $PORT_TO_USE"
sed -i "s/port=\"8080\"/port=\"$PORT_TO_USE\"/g" /usr/local/tomcat/conf/server.xml

# Allow legacy TLS algorithms in Java 8 security policy if needed
for secfile in /usr/local/openjdk-8/jre/lib/security/java.security /usr/lib/jvm/*/jre/lib/security/java.security; do
  if [ -f "$secfile" ]; then
    sed -i 's/TLSv1, //g' "$secfile" 2>/dev/null || true
    sed -i 's/TLSv1.1, //g' "$secfile" 2>/dev/null || true
  fi
done

# Safe memory settings for Render 512MB container (256MB heap + 192MB metaspace)
export CATALINA_OPTS="-Xms128m -Xmx280m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=192m -XX:+UseSerialGC -Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true -Djdk.tls.client.protocols=TLSv1.2,TLSv1.3"

# Configure database settings
PROP_DIR="/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/com/bul/zydex/property"
PROP_FILE="$PROP_DIR/jdbc.properties"

if [ -d "$PROP_DIR" ]; then
  echo "==> Configuring database settings..."
  DEFAULT_JDBC_URL="jdbc:mysql://gateway01.ap-northeast-1.prod.aws.tidbcloud.com:4000/eprocsuite_chargezone?useSSL=true&requireSSL=true&verifyServerCertificate=false&enabledTLSProtocols=TLSv1.2"
  FINAL_JDBC_URL="${JDBC_URL:-$DEFAULT_JDBC_URL}"
  if [[ "$FINAL_JDBC_URL" == *"useSSL=true"* ]] && [[ "$FINAL_JDBC_URL" != *"enabledTLSProtocols"* ]]; then
    FINAL_JDBC_URL="${FINAL_JDBC_URL}&enabledTLSProtocols=TLSv1.2"
  fi
  FINAL_JDBC_USER="${JDBC_USERNAME:-HVtbf3tQkyxXK4C.root}"
  FINAL_JDBC_PASS="${JDBC_PASSWORD:-LACrrRIQSQxK1tDU}"
  FINAL_JDBC_DB="${JDBC_DATABASE:-eprocsuite_chargezone}"

  cat << EOF > "$PROP_FILE"
jdbc.database = $FINAL_JDBC_DB
jdbc.driverClassName = com.mysql.jdbc.Driver
jdbc.url = $FINAL_JDBC_URL
jdbc.username = $FINAL_JDBC_USER
jdbc.password = $FINAL_JDBC_PASS
jdbc2.database = $FINAL_JDBC_DB
jdbc2.driverClassName = com.mysql.jdbc.Driver
jdbc2.url = $FINAL_JDBC_URL
jdbc2.username = $FINAL_JDBC_USER
jdbc2.password = $FINAL_JDBC_PASS
EOF
  echo "==> Database properties configured successfully with database: $FINAL_JDBC_DB"
fi

# Ensure log directory exists
mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/logs

echo "==> Starting Apache Tomcat on port $PORT_TO_USE..."
exec "$@"
