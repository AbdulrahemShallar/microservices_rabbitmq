/**
 * Service class for consuming JSON messages from RabbitMQ.
 * This class listens to a specific JSON queue and processes incoming
 * User objects by logging them for tracking and debugging. It ensures
 * that structured data can be handled as it arrives, allowing for seamless
 * integration within the application.
 */

package com.microservices_rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

    // Listens for JSON messages from the specified RabbitMQ JSON queue
    @RabbitListener(queues = {"${rabbitmq.json.queue}"})
    public void consumerJsonMessage(User user){
        log.info("Received JSON Message -> {}",user.toString());
    }
}
