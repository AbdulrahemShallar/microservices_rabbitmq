/**
 * Service class for consuming messages from RabbitMQ.
 * This class listens to a specific queue and processes incoming messages
 * by logging them for tracking and debugging. It's essential for handling
 * messages sent to the application, ensuring that data can be processed
 * as it arrives.
 */

package com.microservices_rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQConsumer {

    // Listens for messages from the specified RabbitMQ queue
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        log.info("Received Message --> {}",message);
    }
}
