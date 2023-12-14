package com.hehmdalolkek.spring.ordermanagerback.exceptions;

public class OrderDetailsNotFoundException extends RuntimeException{
    public OrderDetailsNotFoundException(int id){
        super("Could not found the order details with order id "+ id);
    }
}
