FROM registry.redhat.io/openjdk/openjdk-11-rhel7:1.15-3
USER root
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar
USER 1001
ENTRYPOINT ["java","-jar","/app/app.jar"]