package com.cotiviti.distributedtracing.mstwo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientServiceException extends RuntimeException {
    private String message;
}
