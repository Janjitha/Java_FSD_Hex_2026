package com.exception;

public class UserNotFoundException extends RuntimeException{
    private String message;

    public UserNotFoundException(String message) {
        super(message);
    }

}

/*
* RuntimeException class has getMessage(String message) method.
* but we need to pass on the message from our class to this super class.
* hence we use super(message) to pass on this message to runtime exception.
*
* Dev Tip: Now we can use e.getMessage() in our controller
* */
