FROM openjdk:8-jdk-slim
EXPOSE 8080
ARG JAR_FILE=target/jobseeker.jar
ADD ${JAR_FILE} jobseeker.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar","/jobseeker.jar"]
