package com.testing.springboot.init;

public class ApplicationStartedWithoutActiveProfileException extends RuntimeException {
    public ApplicationStartedWithoutActiveProfileException() {
        super("Active profile is required to specify working environment");
    }
}
