FROM openjdk:11-jre-slim
MAINTAINER baeldung.com
COPY target/hospitalmanagementsystem-0.0.1-SNAPSHOT.jar hospitalmanagementsystem-0.0.1.jar
ENTRYPOINT ["java","-jar","/hospitalmanagementsystem-0.0.1.jar"]
