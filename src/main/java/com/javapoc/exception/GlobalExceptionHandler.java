package com.javapoc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.web.server.ResponseStatusException.class)
    public org.springframework.http.ResponseEntity<java.util.Map<String, Object>> handleResponseStatusException(org.springframework.web.server.ResponseStatusException ex) {
        java.util.Map<String, Object> body = java.util.Map.of(
                "timestamp", java.time.LocalDateTime.now(),
                "status", ex.getStatusCode().value(),
                "error", ex.getStatusCode().toString(),
                "message", ex.getReason(),
                "path", ""
        );

        return new org.springframework.http.ResponseEntity<>(body, ex.getStatusCode());
    }
}