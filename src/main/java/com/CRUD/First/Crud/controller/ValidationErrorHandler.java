package com.CRUD.First.Crud.controller;

import com.CRUD.First.Crud.entity.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleArgumentValidation(MethodArgumentNotValidException ex){
//        return new ResponseEntity<>(new ApiResponse("failure" , "something goes wrong" , null), HttpStatus.BAD_REQUEST);
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(new ApiResponse<>("failure" , "something goes wrong" , errors), HttpStatus.BAD_REQUEST);
    }
}
