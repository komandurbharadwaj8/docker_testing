# Dockerfile
FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/app_api.jar app.jar
CMD ["java", "-jar", "app_api.jar"]
