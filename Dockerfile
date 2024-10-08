# Use a Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Build the project using Maven
RUN mvn clean package

# Use an official OpenJDK runtime as a base image for the app
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR from the build stage into the new container
COPY --from=build /app/target/mobileStore-0.0.1-SNAPSHOT.jar mobile-store.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "mobile-store.jar"]
