# Stage 1: Build the WAR file
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Deploy the WAR to a Tomcat server
FROM tomcat:10.1-jre21-temurin-noble
COPY --from=build /app/target/TechBit-1.0.0.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat's default port
ENV CATALINA_OPTS="-DDB_HOST=${DB_HOST} -DDB_PORT=${DB_PORT} -DDB_NAME=${DB_NAME} -DDB_USER=${DB_USER} -DDB_PASSWORD=${DB_PASSWORD}"
EXPOSE 8080
# No need for an ENTRYPOINT here, Tomcat image handles it