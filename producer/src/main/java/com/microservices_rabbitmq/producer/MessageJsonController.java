package com.microservices_rabbitmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    @Autowired
    private RabbitMQJsonProducer jsonProducer;

    /**
     * Endpoint to publish a JSON message to RabbitMQ.
     * Takes a User object from the request body and sends it as a JSON message
     * through the RabbitMQJsonProducer.
     *
     * @param user The User object to be sent as a JSON message
     * @return ResponseEntity with a success message once the message is published
     */
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message to RabbitMQ ... ");
    }
}
