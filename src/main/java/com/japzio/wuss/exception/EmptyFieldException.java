package com.japzio.wuss.exception;

public class EmptyFieldException extends Exception{

    public EmptyFieldException () {
        super("Field with null or zero-length value is not allowed!");
    }

    public EmptyFieldException (String message) {
        super(message);
    }

}
