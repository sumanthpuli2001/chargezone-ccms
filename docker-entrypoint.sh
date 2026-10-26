#!/bin/bash
set -e

# Render and other cloud platforms provide dynamic $PORT (e.g. 10000)
if [ -n "$PORT" ]; then
  echo "==> Configuring Tomcat port to $PORT"
  sed -i "s/port=\"8080\"/port=\"$PORT\"/g" /usr/local/tomcat/conf/server.xml
fi

# Set memory limits to fit within Render free tier (512MB RAM)
export CATALINA_OPTS="-Xms128m -Xmx384m -XX:+UseG1GC"

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
