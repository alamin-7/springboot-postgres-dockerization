FROM openjdk:11
ADD target/dockerspringboot-0.0.1-snapshot.jar dockerspringboot-0.0.1-snapshot.jar
ENTRYPOINT ["java", "-jar","dockerspringboot-0.0.1-snapshot.jar"]
EXPOSE 8080
