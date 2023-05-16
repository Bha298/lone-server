FROM openjdk:8
ARG JAR_FILE=target/*.jar

ENTRYPOINT ["java","-jar","/lone-server.jar"]
EXPOSE 2001
