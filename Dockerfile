FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/mobileStore-0.0.1-SNAPSHOT.jar mobile-store.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "mobile-store.jar"]
