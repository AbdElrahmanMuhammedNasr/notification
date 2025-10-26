FROM openjdk:21-slim AS build
COPY target/notification-0.0.1-SNAPSHOT.jar notification.jar
ENTRYPOINT ["java","-jar","/notification.jar"]
