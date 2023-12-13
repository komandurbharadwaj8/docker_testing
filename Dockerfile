# Dockerfile
FROM openjdk:11-jre-slim
WORKDIR /app
run ./mvnw clean install 
COPY target/app_api.jar app.jar
CMD ["java", "-jar", "app_api.jar"]
