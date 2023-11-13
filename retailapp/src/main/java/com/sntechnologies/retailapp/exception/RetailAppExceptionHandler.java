package com.sntechnologies.retailapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RetailAppExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String ,String> handleValidation(MethodArgumentNotValidException ex){
        Map<String,String> ListOfError= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName=((FieldError)error).getField();
            String  errorMessage=error.getDefaultMessage();
            ListOfError.put(fieldName,errorMessage);
        });
        return ListOfError;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public @ResponseBody String ProductNotFoundExceptions(ProductNotFoundException ex){
        return ex.getMessage();

    }
}