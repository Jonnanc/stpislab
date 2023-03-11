package com.Api.category;


public class CategoryControllerNotFoundException extends Exception {
    private String productAlias;
    private Integer id;
    public CategoryControllerNotFoundException(String productAlias) {
        super(String.format("Not found with alias : '%s'", productAlias));
    }

    public CategoryControllerNotFoundException(Integer id) {
        super(String.format("Not found with alias : '%s'", id));
    }
}