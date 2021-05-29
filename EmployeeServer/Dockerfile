FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} EmployeeServer.jar
ENTRYPOINT ["java","-jar","/EmployeeServer.jar"]