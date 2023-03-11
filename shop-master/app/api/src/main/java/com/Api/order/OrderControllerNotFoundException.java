package com.Api.order;


public class OrderControllerNotFoundException extends Exception {
    private Integer id;
    public OrderControllerNotFoundException(Integer id) {
        super(String.format("Not found with alias : '%s'", id));
    }
}