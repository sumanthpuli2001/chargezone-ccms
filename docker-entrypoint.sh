#!/bin/bash
set -e

# Disable Tomcat shutdown port completely so Render port-scanner only sees the HTTP port
sed -i 's/<Server port="8005"/<Server port="-1"/g' /usr/local/tomcat/conf/server.xml
sed -i 's/<Server port="[0-9]*"/<Server port="-1"/g' /usr/local/tomcat/conf/server.xml

# Render and other cloud platforms provide dynamic $PORT (e.g. 10000)
if [ -n "$PORT" ]; then
  echo "==> Configuring Tomcat HTTP port to $PORT"
  sed -i "s/port=\"8080\"/port=\"$PORT\"/g" /usr/local/tomcat/conf/server.xml
fi

# Optimize Tomcat JAR scanning to speed up boot by 60+ seconds
sed -i 's/tomcat.util.scan.StandardJarScanFilter.jarsToScan=/tomcat.util.scan.StandardJarScanFilter.jarsToScan=*jstl*,*standard*,*taglibs*,/g' /usr/local/tomcat/conf/catalina.properties

# Allow legacy TLS algorithms in Java 8 security policy if needed
for secfile in /usr/local/openjdk-8/jre/lib/security/java.security /usr/lib/jvm/*/jre/lib/security/java.security; do
  if [ -f "$secfile" ]; then
    sed -i 's/TLSv1, //g' "$secfile" 2>/dev/null || true
    sed -i 's/TLSv1.1, //g' "$secfile" 2>/dev/null || true
  fi
done

# Set JVM options: fit safely within 512MB RAM, prefer IPv4, enable TLS 1.2, fast entropy & SerialGC
export CATALINA_OPTS="-Xms128m -Xmx320m -XX:MaxMetaspaceSize=160m -XX:+UseSerialGC -Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true -Djdk.tls.client.protocols=TLSv1.2,TLSv1.3"

# Unpack ROOT.war if present using jar
if [ -f /usr/local/tomcat/webapps/ROOT.war ]; then
  echo "==> Extracting ROOT.war..."
  mkdir -p /usr/local/tomcat/webapps/ROOT
  cd /usr/local/tomcat/webapps/ROOT
  jar -xf ../ROOT.war
  rm -f ../ROOT.war
  cd /usr/local/tomcat
fi

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

echo "==> Starting Apache Tomcat..."
exec "$@"
