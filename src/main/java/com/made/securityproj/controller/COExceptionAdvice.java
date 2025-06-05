package com.made.securityproj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class COExceptionAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity
                .badRequest().body(Map.of("error", e.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleGeneral(Exception e) {
        return ResponseEntity.internalServerError().body(Map.of("error", "서버 내부 오류", "null", e.getMessage()));
    }

}
