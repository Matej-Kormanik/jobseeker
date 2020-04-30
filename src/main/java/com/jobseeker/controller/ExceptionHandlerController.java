package com.jobseeker.controller;

import com.jobseeker.dto.exception.ExceptionalResponse;
import com.jobseeker.dto.exception.ResourceNotCreatedException;
import com.jobseeker.dto.exception.ResourceNotFoundException;
import com.jobseeker.dto.exception.ResourceNotUpdatedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    public ResponseEntity<ExceptionalResponse> notFoundHandler(ResourceNotFoundException exception) {
        ExceptionalResponse response = new ExceptionalResponse(
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionalResponse> notCreatedHandler(ResourceNotCreatedException exception) {
        ExceptionalResponse response = new ExceptionalResponse(
                NOT_ACCEPTABLE.value(),
                NOT_ACCEPTABLE.getReasonPhrase(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionalResponse> notUpdatedHandler(ResourceNotUpdatedException exception) {
        ExceptionalResponse response = new ExceptionalResponse(
                NOT_ACCEPTABLE.value(),
                NOT_ACCEPTABLE.getReasonPhrase(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionalResponse> generalExceptionHandler(Exception exception) {
        ExceptionalResponse response = new ExceptionalResponse(
                BAD_REQUEST.value(),
                BAD_REQUEST.getReasonPhrase(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, BAD_REQUEST);
    }

}
