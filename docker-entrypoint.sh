#!/bin/bash
set -e

# Render and other cloud platforms provide dynamic $PORT (e.g. 10000)
if [ -n "$PORT" ]; then
  echo "==> Configuring Tomcat port to $PORT and binding to 0.0.0.0"
  sed -i "s/port=\"8080\"/port=\"$PORT\" address=\"0.0.0.0\"/g" /usr/local/tomcat/conf/server.xml
fi

# Optimize Tomcat JAR scanning to speed up boot by 60+ seconds
sed -i 's/tomcat.util.scan.StandardJarScanFilter.jarsToScan=/tomcat.util.scan.StandardJarScanFilter.jarsToScan=*jstl*,*standard*,*taglibs*,/g' /usr/local/tomcat/conf/catalina.properties

# Set JVM options: fit safely within 512MB RAM, prefer IPv4 stack
export CATALINA_OPTS="-Xms128m -Xmx288m -XX:MaxMetaspaceSize=128m -XX:+UseG1GC -Djava.net.preferIPv4Stack=true"

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
  cat << EOF > "$PROP_FILE"
jdbc.database = ${JDBC_DATABASE:-eprocsuite_chargezone}
jdbc.driverClassName = com.mysql.jdbc.Driver
jdbc.url = ${JDBC_URL:-jdbc:mysql://localhost:3306/eprocsuite_chargezone}
jdbc.username = ${JDBC_USERNAME:-root}
jdbc.password = ${JDBC_PASSWORD:-root}
jdbc2.database = ${JDBC_DATABASE:-eprocsuite_chargezone}
jdbc2.driverClassName = com.mysql.jdbc.Driver
jdbc2.url = ${JDBC_URL:-jdbc:mysql://localhost:3306/eprocsuite_chargezone}
jdbc2.username = ${JDBC_USERNAME:-root}
jdbc2.password = ${JDBC_PASSWORD:-root}
EOF
  echo "==> Database properties configured successfully."
fi

# Ensure log directory exists
mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/logs

echo "==> Starting Apache Tomcat..."
exec "$@"
