FROM openjdk:17-oracle

WORKDIR /app

ADD /target/JUnitTestProject-0.0.1-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]

