package com.nadiajaay.pika_base.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nadiajaay.pika_base.dto.ValidationErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception) {
                
        List<String> errors = new ArrayList<>();
        
        // Extract each validation message from the exception.
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.add(fieldError.getDefaultMessage());
        }
        
        ValidationErrorResponse response = new ValidationErrorResponse(400, errors);
        return ResponseEntity.badRequest().body(response);
                
    }
}
