package com.tony.gestionnairedetache.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;


import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException ex , HttpServletRequest request) {
    ApiError apiError = new ApiError();

    String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    apiError.setTimestamp(LocalDateTime.now());
    apiError.setStatus(400);
    apiError.setError("Bad Request");
    apiError.setMessage(message);
    apiError.setPath(request.getRequestURI());
    return ResponseEntity.badRequest().body(apiError);
}

@ExceptionHandler(TaskNotFoundException.class)
public ResponseEntity<ApiError> handleTaskNotFound(TaskNotFoundException ex, HttpServletRequest request){
    
    ApiError apiError = new ApiError();
    String message = ex.getMessage();
    apiError.setTimestamp(LocalDateTime.now());
    apiError.setStatus(404);
    apiError.setError("Not Found");
    apiError.setMessage(message);
    apiError.setPath(request.getRequestURI());
    return ResponseEntity.status(404).body(apiError);
}

@ExceptionHandler(Exception.class)
public ResponseEntity<ApiError> handleAllException(Exception ex, HttpServletRequest request){
    ApiError apiError = new ApiError();
    apiError.setTimestamp(LocalDateTime.now());
    apiError.setStatus(500);
    apiError.setError("Internal Server Error");
    apiError.setMessage("Une erreur inattendue s'est produite");
    apiError.setPath(request.getRequestURI());
    return ResponseEntity.status(500).body(apiError);
}

}
