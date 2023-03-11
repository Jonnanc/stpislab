package com.Api.product;


public class ProductNotFoundException extends Exception {
    private String productAlias;
    private Integer id;
    public ProductNotFoundException(String productAlias) {
        super(String.format("Not found with alias : '%s'", productAlias));
    }

    public ProductNotFoundException(Integer id) {
        super(String.format("Not found with alias : '%s'", id));
    }
}