package com.mlorenzo.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandlerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandlerController.class);

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<ApiError> handleApiRequestException(ApiRequestException ex) {
        ApiError apiException = new ApiError(ex.getMessage(), ex, HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return ResponseEntity.badRequest().body(apiException);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiError handleNotFoundException(NotFoundException ex) {
        return new ApiError(ex.getMessage(), ex, HttpStatus.NOT_FOUND, ZonedDateTime.now());
    }
}
