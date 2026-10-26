# ==========================================
# Step 1: Multi-stage Build with Maven & Java 8
# ==========================================
FROM maven:3.8.6-openjdk-8-slim AS builder

WORKDIR /build

# Copy root pom.xml and all modules
COPY pom.xml ./
COPY controller ./controller
COPY dao ./dao
COPY model ./model
COPY service ./service
COPY util ./util
COPY validator ./validator
COPY web ./web
COPY zydex ./zydex

# Build all modules using root pom.xml
RUN mvn clean package -DskipTests -B

# ==========================================
# Step 2: Apache Tomcat 9 Runtime on Java 8
# ==========================================
FROM tomcat:9.0-jdk8-openjdk-slim

WORKDIR /usr/local/tomcat

# Remove default Tomcat webapps
RUN rm -rf webapps/*

# Copy built WAR as ROOT.war
COPY --from=builder /build/web/target/web-*.war webapps/ROOT.war

# Copy entrypoint script and ensure Unix line endings
COPY docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh
RUN sed -i 's/\r$//' /usr/local/bin/docker-entrypoint.sh && chmod +x /usr/local/bin/docker-entrypoint.sh

# Expose default port (Render overrides this with $PORT)
EXPOSE 8080

ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
CMD ["catalina.sh", "run"]
