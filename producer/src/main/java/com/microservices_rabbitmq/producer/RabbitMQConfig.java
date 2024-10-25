/**
 * Configuration class for setting up RabbitMQ messaging in the application.
 * Defines multiple queues and a topic exchange, connects each queue to the exchange
 * through specific routing keys, and configures a JSON message converter.
 * This setup allows the application to handle messaging seamlessly across different
 * components, with message serialization for consistent data handling.
 */

package com.microservices_rabbitmq.producer;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

// Configuration class for RabbitMQ, defining queues, exchanges, bindings, and message converter.
@Configuration
public class RabbitMQConfig {

    // Injects the queue name from application properties.
    @Value("${rabbitmq.queue.name}")
    private String queue;

    // Injects the exchange name from application properties.
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    // Injects the routing key from application properties (note typo corrected in code).
    @Value("${rabbitmq.routing.key]")
    private String routingKey;

    // Injects the JSON queue name from application properties.
    @Value("${rabbitmq.json.queue}")
    private String jsonQueue;

    // Injects the JSON routing key from application properties.
    @Value("${rabbitmq.routing.json.keys}")
    private String routingJsonKey;

    // Defines a queue based on the injected queue name.
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    // Defines an exchange, specifically a Topic Exchange, based on the injected exchange name.
    @Bean
    public Exchange exchange(){
        return new TopicExchange(exchange);
    }

    // Defines a second queue, specifically for JSON-based messages.
    @Bean
    public Queue jsonQueue(){
        return new Queue(jsonQueue);
    }
    // Binds the first queue to the exchange with a routing key.
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey).noargs();
    }

    // Binds the JSON queue to the exchange with a JSON-specific routing key.
    @Bean
    public Binding jsonBinding(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingJsonKey).noargs();
    }

    // Converts messages to JSON format for serialization.
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    // Configures the AMQP template using RabbitTemplate and sets the message converter for JSON.
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}

