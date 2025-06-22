package org.example.exception;

public class CourseDependencyException extends RuntimeException {
    public CourseDependencyException(String message) {
        super(message);
    }
}
