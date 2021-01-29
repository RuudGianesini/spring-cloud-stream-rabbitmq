#!/bin/bash

cd ecommerce/ && ./mvnw spring-boot:build-image && cd ..
cd billing/ && ./mvnw spring-boot:build-image && cd ..

docker image tag ruudg/ecommerce:0.0.1-SNAPSHOT ruudg/ecommerce:latest
docker image tag ruudg/billing:0.0.1-SNAPSHOT ruudg/billing:latest

docker-compose up