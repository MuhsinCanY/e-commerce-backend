package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    ResponseEntity<StoreErrorResponse> handleException(StoreException storeException) {

        StoreErrorResponse errorResponse = new StoreErrorResponse();
        errorResponse.setMessage(storeException.getMessage());
        errorResponse.setStatus(storeException.getHttpStatus().value());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, storeException.getHttpStatus());
    }

    @ExceptionHandler
    ResponseEntity<StoreErrorResponse> handleException(Exception exception) {

        StoreErrorResponse errorResponse = new StoreErrorResponse();
        errorResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
