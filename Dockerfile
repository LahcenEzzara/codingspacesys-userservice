# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/UserService-0.0.1-SNAPSHOT.jar userservice.jar

# Expose the port the service listens on
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "userservice.jar"]