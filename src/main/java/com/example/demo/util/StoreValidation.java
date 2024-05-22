package com.example.demo.util;

import com.example.demo.exceptions.StoreException;
import org.springframework.http.HttpStatus;

public class StoreValidation {

    private StoreValidation() {
    }

    public static void checkId(Long id) {
        if (id == null || id <= 0) {
            throw new StoreException("ID must be greater than zero.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new StoreException("Name must not be null or empty.", HttpStatus.BAD_REQUEST);
        }
    }
}
