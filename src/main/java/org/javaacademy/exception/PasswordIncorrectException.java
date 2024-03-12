package org.javaacademy.exception;

public class PasswordIncorrectException extends RuntimeException {
    public PasswordIncorrectException() {
    }

    public PasswordIncorrectException(String message) {
        super(message);
    }
}
