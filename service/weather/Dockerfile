FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar weather-0.0.1.jar
ENTRYPOINT ["java","-jar","/weather-0.0.1.jar"]
