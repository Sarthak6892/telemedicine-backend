FROM openjdk:27-ea-oraclelinux9
ADD target/telemedicine-backend-0.0.1-SNAPSHOT.jar telemedicine-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/telemedicine-backend-0.0.1-SNAPSHOT.jar"]