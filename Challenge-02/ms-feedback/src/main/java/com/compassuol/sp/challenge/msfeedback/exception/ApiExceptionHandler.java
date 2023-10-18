package com.compassuol.sp.challenge.msfeedback.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(){
        var problem = new Problem(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity<Object> handlerMethodArgumentNotValidException(EmptyResultDataAccessException ex){
        var problem = new Problem(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Object> handleBadRequest() {
        var problem = new Problem(ErrorCode.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(FeedBackNotFoundException.class)
    public final ResponseEntity<Object> handlerProductNotFound(FeedBackNotFoundException exception){
        var problem = new Problem(exception.getErrorCode(), exception.getStatus());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

}
