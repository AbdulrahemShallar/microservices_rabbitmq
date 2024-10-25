/**
 * Service class for sending JSON-based messages to RabbitMQ.
 * Configured to use a specific exchange and routing key for JSON data, this class
 * uses a User object as the message payload. It leverages RabbitTemplate to publish
 * JSON messages, logging each message for traceability. Ideal for transmitting
 * structured data across different components with ease and consistency.
 */
package com.microservices_rabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonProducer {

    // Injects the exchange name from application properties
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    // Injects the routing key for JSON messages from application properties
    @Value("${rabbitmq.routing.json.keys}")
    private String routingJsonKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Sends a JSON message to RabbitMQ, using a User object as the message payload.
     * Logs the message's content for tracking before sending it to the specified
     * exchange and JSON-specific routing key.
     *
     * @param user The User object to send as a JSON message
     */
    public void sendJsonMessage(User user){
        log.info("Json message send -> {}",user.toString());
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);
    }
}

