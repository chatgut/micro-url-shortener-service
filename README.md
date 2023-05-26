# Micro url shortener service

Welcome to the Micro URL Shortener Service! This repository contains the code and resources for a simple and efficient
URL shortening service. Easily convert long web addresses into short, concise URLs!

## Getting Started

Start a MongoDB docker container:

```
docker run --name mongodb -p 27017:27017 -d mongo:latest
```

Run the application with below environment variables or update them if needed:

`MONGO_DB_URI=mongodb://mongodb:27017`  
`APP_DOMAIN_NAME=http://localhost:8080`

<br />
Example of command with default values:

```
docker run -p 8004:8080 --name micro-url-shortener-service -e MONGO_DB_URI=mongodb://mongodb:27017 -e APP_DOMAIN_NAME=http://localhost:8080 ghcr.io/chatgut/micro-url-shortener-service:main
```

## API

### Create a new short URL

* `POST /`
  * JSON format for POST:
    ```
    {
    "url": https://github.com/chatgut/micro-url-shortener-service
    }
    ```
  * Example output:
    ```
    {
    "short_url": "http://127.0.0.1:8080/eE"
    }
    ```

### Get original URL

* `GET /{shortPath}`
  * Example full GET: `http://localhost:8080/eE`
  * Example output: The website of https://github.com/chatgut/micro-url-shortener-service

<br />

###### Disclaimer: This project is a school assignment and is solely for educational purposes. The project is not intended for commercial use or distribution.
