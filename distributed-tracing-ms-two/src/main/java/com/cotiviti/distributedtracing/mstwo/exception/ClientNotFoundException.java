package com.cotiviti.distributedtracing.mstwo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientNotFoundException extends RuntimeException {
    private String message;
}
