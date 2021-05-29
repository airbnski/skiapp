FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar resort-0.0.1.jar
ENTRYPOINT ["java","-jar","/resort-0.0.1.jar"]
