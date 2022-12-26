package com.japzio.wuss.exception;

public class UrlNotFoundException extends Exception{

    public UrlNotFoundException() {
        super("Url not found in cache!");
    }

    public UrlNotFoundException(String message) {
        super(message);
    }

}
