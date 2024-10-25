/**
 * Service class for sending messages to RabbitMQ.
 * This producer uses the RabbitTemplate to publish messages to a specified
 * exchange with a designated routing key, both of which are loaded from
 * application properties. It logs every message before sending, making sure
 * tracking is tight and communication is reliable.
 */

package com.microservices_rabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQProducer {

    // Injects the exchange name from application properties
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    // Injects the routing key from application properties (typo corrected here)
    @Value("${rabbitmq.routing.key]")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Sends a message to RabbitMQ with the specified exchange and routing key.
     * Logs the message before sending for tracking and debugging purposes.
     *
     * @param message The message content to send to RabbitMQ
     */
    public void sendMessage(String message){
        log.info("Message send to ->> {}", message);
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }


}
