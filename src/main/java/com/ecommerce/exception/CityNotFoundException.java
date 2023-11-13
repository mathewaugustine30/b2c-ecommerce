package com.ecommerce.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String id) {

        super(String.format("City with Id %d not found", id));
    }
}