# Java Microservices
The microservices are written in Java and make use of the Spring framework. The following project uses the Gradle build tool.

## To build the jar files
cd into `skiapp/service`

run gradle command `./gradlew clean build`

This builds FAT jars into the respective project's build directories.

- Resort JAR: `skiapp/service/resort/build/libs/resort-0.0.1.jar`

- Weather JAR: `skiapp/service/weather/build/libs/weather-0.0.1.jar`


## To run the microservices locally
cd into the directory where JAR is located

By default cd `skiapp/service/resort/build/libs/` or `skiapp/service/weather/build/libs/`

run java jar `java -jar resort-0.0.1.jar`

run java jar `java -jar weather-0.0.1.jar`
