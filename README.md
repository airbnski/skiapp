# airbnski 
This file describes the AirBNSki micro-services based application and its components.
Please visit our Wiki for more information: https://github.com/airbnski/skiapp/wiki.

- The application can be accessed here: http://airbnski.ch

- The project source code accessed here: https://github.com/airbnski/skiapp

- The latest docker containers can be accessed here: https://hub.docker.com/u/airbnski

## Application Components
Our application is based on a scalable micro-service architecture, and consists of 3 individiual micro services.
1. React SPA served with Nginx Server
2. Java Resort API microservice 
3. Java Weather API microservice

**To access the microservices in production**

All of AirBNSKi's infrastructure is hosted on the Google Cloud Platform.

- React Front: http://airbnski.ch `Port:80`

- Resort Microservice: http://airbnski.ch:8082 `Port:8082`

- Weather Microservice: http://airbnski.ch:8081 `Port:8081`

- Common Microservice

**To run the microservicess locally using Docker**

Make sure you're in the root directory `/skiapp`

run docker-compose command `docker-compose up -d` using docker-compose.yaml file in the directory

## 1. React SPA served with Nginx Server
1. **For development using source code**

View the readme file in `skiapp/ui` directory.

2. **For making a docker image from source code**

cd into `skiapp/ui`

run docker command `docker build -t airbnski/ui .` using Dockerfile in the directory

3. **For running docker image individually**

run docker command `docker container run -d -p 80:80 airbnski/ui` 

Important: The app is configured to work on port 80

## 2. Java Resort API microservice 
1. **For development using source code**

View the readme file in `skiapp/service/resort` directory.

2. **For making a docker image from source code**

cd into `skiapp/service/resort`

run docker command `docker build -t airbnski/resort .` using Dockerfile in the directory

3. **For running docker image individually**

run docker command `docker container run -d -p 8082:8082 airbnski/resort` 

Important: The app is configured to work on port 8082


## 3. Java Weather API microservice
1. **For development using source code**

View the readme file in `skiapp/service/weather` directory.

2. **For making a docker image from source code**

cd into `skiapp/service/weather`

run docker command `docker build -t airbnski/weather .` using Dockerfile in the directory

3. **For running docker image individually**

run docker command `docker container run -d -p 8081:8081 airbnski/weather` 

Important: The app is configured to work on port 8081
