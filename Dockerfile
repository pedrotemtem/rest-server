FROM openjdk:17
COPY target/demo-0.0.1-SNAPSHOT.jar /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/tmp/demo-0.0.1-SNAPSHOT.jar"]