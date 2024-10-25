# RabbitMQ Microservices Project

## Overview
This project demonstrates the implementation of a microservices architecture using RabbitMQ for messaging. It includes producers and consumers for both plain text and JSON messages, enabling seamless communication between services.

## Features
- **Message Producers**: Send messages to RabbitMQ using two different formats: plain text and JSON.
- **Message Consumers**: Listen for messages from RabbitMQ queues and process them accordingly.
- **RabbitMQ Integration**: Utilizes Spring AMQP for easy integration with RabbitMQ.
- **Logging**: Each component logs its actions for better tracking and debugging.

## Technologies Used
- Java
- Spring Boot
- Spring AMQP
- RabbitMQ
- Lombok

## Getting Started

### Prerequisites
- Java 11 or higher
- RabbitMQ server running locally
- Maven

# Components
## RabbitMQ Producer
***Plain Message Producer:*** RabbitMQProducer
>Sends plain text messages to RabbitMQ.

***JSON Message Producer:*** RabbitMQJsonProducer
>Sends JSON messages using a User object.

## RabbitMQ Consumer
***Plain Message Consumer:*** RabbitMQConsumer
>Listens for and processes plain text messages.

***JSON Message Consumer:*** RabbitMQJsonConsumer
>Listens for and processes JSON messages as User objects.

### REST Controllers
***Message Controller: MessageController***
>Exposes an endpoint to publish plain text messages via HTTP GET.

***JSON Message Controller:*** MessageJsonController
>Exposes an endpoint to publish JSON messages via HTTP POST.

### API Endpoints
***Publish Plain Message***
* GET /api/v1/publish?message={your_message}

***Publish JSON Message***
* POST /api/v1/publish
* Request Body: JSON representation of the User object.
