#!/bin/bash
set -e

# Render and other cloud platforms provide dynamic $PORT (e.g. 10000)
if [ -n "$PORT" ]; then
  echo "==> Configuring Tomcat port to $PORT"
  sed -i "s/port=\"8080\"/port=\"$PORT\"/g" /usr/local/tomcat/conf/server.xml
fi

# Set memory limits to fit within Render free tier (512MB RAM)
export CATALINA_OPTS="$CATALINA_OPTS -Xms128m -Xmx384m -XX:+UseG1GC"

# Unpack ROOT.war if present using jar
if [ -f /usr/local/tomcat/webapps/ROOT.war ]; then
  echo "==> Extracting ROOT.war..."
  mkdir -p /usr/local/tomcat/webapps/ROOT
  cd /usr/local/tomcat/webapps/ROOT
  jar -xf ../ROOT.war
  rm -f ../ROOT.war
  cd /usr/local/tomcat
fi

PROP_FILE="/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/com/bul/zydex/property/jdbc.properties"

if [ -f "$PROP_FILE" ]; then
  echo "==> Configuring database settings..."
  if [ -n "$JDBC_URL" ]; then
    echo "==> Setting jdbc.url: $JDBC_URL"
    sed -i "s|^jdbc.url.*|jdbc.url = $JDBC_URL|g" "$PROP_FILE"
    export CATALINA_OPTS="$CATALINA_OPTS -Djdbc.url=$JDBC_URL"
  fi
  if [ -n "$JDBC_USERNAME" ]; then
    echo "==> Setting jdbc.username: $JDBC_USERNAME"
    sed -i "s|^jdbc.username.*|jdbc.username = $JDBC_USERNAME|g" "$PROP_FILE"
    export CATALINA_OPTS="$CATALINA_OPTS -Djdbc.username=$JDBC_USERNAME"
  fi
  if [ -n "$JDBC_PASSWORD" ]; then
    echo "==> Setting jdbc.password"
    sed -i "s|^jdbc.password.*|jdbc.password = $JDBC_PASSWORD|g" "$PROP_FILE"
    export CATALINA_OPTS="$CATALINA_OPTS -Djdbc.password=$JDBC_PASSWORD"
  fi
  if [ -n "$JDBC_DATABASE" ]; then
    echo "==> Setting jdbc.database: $JDBC_DATABASE"
    sed -i "s|^jdbc.database.*|jdbc.database = $JDBC_DATABASE|g" "$PROP_FILE"
    export CATALINA_OPTS="$CATALINA_OPTS -Djdbc.database=$JDBC_DATABASE"
  fi
fi

# Ensure log directory exists
mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/logs

echo "==> Starting Apache Tomcat..."
exec "$@"
