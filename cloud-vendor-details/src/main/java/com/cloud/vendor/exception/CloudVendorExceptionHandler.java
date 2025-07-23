package com.cloud.vendor.exception;

import com.cloud.vendor.CloudVendorDetailsApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {


    @ExceptionHandler(CloudVendorNotFoundException.class)
    public ResponseEntity<Object> handleException(CloudVendorNotFoundException cloudVendorNotFoundException){
        CloudVendorExceptionDetails  cloudVendorExceptionDetails = new CloudVendorExceptionDetails(cloudVendorNotFoundException.getMessage(), cloudVendorNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorExceptionDetails, HttpStatus.NOT_FOUND);
    }
}
