FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} h2-database.jar
ENTRYPOINT ["java","-jar","/h2-database.jar"]