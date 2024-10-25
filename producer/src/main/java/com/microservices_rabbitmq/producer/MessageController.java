package com.microservices_rabbitmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    /**
     * Endpoint to publish a plain text message to RabbitMQ.
     * Takes a message string as a request parameter and sends it through the
     * RabbitMQProducer.
     *
     * @param message The message content to send to RabbitMQ
     * @return ResponseEntity with a success message once the message is published
     */
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ....");
    }
}
