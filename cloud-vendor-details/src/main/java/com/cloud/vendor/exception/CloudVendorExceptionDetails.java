package com.cloud.vendor.exception;

import org.springframework.http.HttpStatus;

public class CloudVendorExceptionDetails {

    private String message;
    private Throwable cause;
    private HttpStatus status;

    public CloudVendorExceptionDetails(String message, Throwable cause, HttpStatus httpStatus) {
        this.message = message;
        this.cause = cause;
        this.status = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
