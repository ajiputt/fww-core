FROM openjdk:17-jdk
ARG JAR_FILE=target/fww-core-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} fww-core-1.0.jar
ENTRYPOINT ["java","-jar","/fww-core-1.0.jar"]