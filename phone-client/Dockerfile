FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG ENV_PROP=HI_ENV
COPY ${JAR_FILE} phone-client.jar
ENV demoEnv=${ENV_PROP}
ENTRYPOINT ["java","-jar","/phone-client.jar"]