package com.cloud.vendor.response;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    @Bean
    public static ResponseEntity<Object> getResponseEntity(String message, HttpStatus status, Object body) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status);
        response.put("data", body);

        return new ResponseEntity<>(response,status);
    }
}
