FROM openjdk:8

COPY target/themchoisebackend-0.0.1-SNAPSHOT.jar themchoisebackend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/themchoisebackend-0.0.1-SNAPSHOT.jar"]