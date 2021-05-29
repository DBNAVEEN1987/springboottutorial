FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} server-registry.jar
ENTRYPOINT ["java","-jar","/server-registry.jar"]