FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} feign-demo.jar
ENTRYPOINT ["java","-jar","/feign-demo.jar"]