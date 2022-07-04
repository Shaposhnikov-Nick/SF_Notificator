package com.sfnotificator.exceptionHandling;

public class NoSuchHomeworkException extends RuntimeException{
    public NoSuchHomeworkException(String message) {
        super(message);
    }
}
