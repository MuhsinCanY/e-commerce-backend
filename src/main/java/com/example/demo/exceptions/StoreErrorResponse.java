package com.example.demo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
