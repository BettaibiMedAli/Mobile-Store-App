# Use an official Java runtime as a base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged application jar into the container
COPY target/mobileStore-0.0.1-SNAPSHOT.jar mobile-store.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "mobile-store.jar"]
