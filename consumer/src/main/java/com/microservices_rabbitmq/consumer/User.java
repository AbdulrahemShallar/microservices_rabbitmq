package com.microservices_rabbitmq.consumer;

import lombok.Data;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
