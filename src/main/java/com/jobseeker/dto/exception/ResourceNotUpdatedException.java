package com.jobseeker.dto.exception;

public class ResourceNotUpdatedException extends RuntimeException {

    public ResourceNotUpdatedException(String message) {
        super(message);
    }

    public ResourceNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotUpdatedException(Throwable cause) {
        super(cause);
    }
}
