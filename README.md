# Micro url shortener service

Welcome to the Micro URL Shortener Service! This repository contains the code and resources for a simple and efficient URL shortening service. Easily convert long web addresses into short, concise URLs!


## Getting Started

This service uses a Mongo database to save the generated URL mappings, so you can start off by spinning up a MongoDB container. For example by using the command:
```
docker run --name mongodb -p 27017:27017 -d mongo:latest
```

Now, run this application with the required environment variables.

MONGO_DB_URI - 
APP_DOMAIN_NAME - Insert a domain name that you own and want to use. In dev mode this defaults to: http://localhost:8080.

format på miljövariabler
Configure the service by setting up the required environment variables.


## API

To convert a long URL to a shorter version, make a POST request: 

POST: /short
```
{
  "url": [ORIGINAL_URL]
}
```

If a shortened URL could be successfully provided, you will get a response code of 200 or 201, together with a JSON-object:

```
{
  "short_url": [SHORT_URL as String]
}
```

Later when you click on a shortened URL, you will be redirected to the original URL.


###### Disclaimer: This project is a school assignment and is solely for educational purposes. The project is not intended for commercial use or distribution.






docker network create mynetwork
docker run -p 27017:27017 --name mymongo --network-alias mymongo --network mynetwork -d mongo:latest
docker pull ghcr.io/chatgut/micro-url-shortener-service:main
docker run -p 8004:8080 --name myURLservice --network-alias myURLservice --network mynetwork -e MONGO_DB_URI=mongodb://mymongo:27017 -e APP_DOMAIN_NAME=http://127.0.0.1:8004 ghcr.io/chatgut/micro-url-shortener-service:main
docker run -p 8080:8080 --name frontend --network-alias myfrontend --network mynetwork chatgut/frontend:version


docker run -p 8004:8080 --name micro-url-shortener-service --network-alias myURLservice --network mynetwork -e MONGO_DB_URI=mongodb://mymongo:27017 -e APP_DOMAIN_NAME=http://127.0.0.1:8080 chatgut/micro-url-shortener-service:version
docker run -p 8080:8080 --name frontend --network-alias myfrontend --network mynetwork chatgut/frontend:version






# micro-url-shortener-service

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/micro-url-shortener-service-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- MongoDB client ([guide](https://quarkus.io/guides/mongodb)): Connect to MongoDB in either imperative or reactive style

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
