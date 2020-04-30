package com.jobseeker.dto.exception;

public class ResourceNotCreatedException extends RuntimeException {

    public ResourceNotCreatedException(String message) {
        super(message);
    }

    public ResourceNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotCreatedException(Throwable cause) {
        super(cause);
    }
}
