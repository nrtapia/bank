# BankApp Backend

This project was generated with [Spring Initializr](https://start.spring.io/) version 2.12.

CI enable with CircleCI, config file in `/.circleci/config.yml`

## Development server

Run `$ mvn spring-boot:run` for a dev server. Navigate to `http://localhost:8080/`. 

## Build

Run `mvn package` to build the project. The build artifacts will be stored in the `target/` directory. 

## Config

To enable CORS Origins update `src/main/resources/application.properties` change property `cors.allowed.origins` with the frontend application URL.

## Run

Run `java -jar target/bank-0.0.1-SNAPSHOT.jar`

## Docker

Create docker image with `Dockerfile` run command `./docker build . -t ntapia/bank-app:1.0`

Create containers with `docker-compose.yml` run command `./docker-compose up -d`

Open the Web App with a browse in `http://localhost`
