package com.simon.taskapp.controller;

import com.simon.taskapp.domain.dto.ErrorDto;
import com.simon.taskapp.domain.dto.ErrorResponse;
import com.simon.taskapp.domain.exceptions.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse>handleException(
            RuntimeException ex, WebRequest request
    )
    {
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto>handleException(
            MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation failed.");
        ErrorDto errorDto=new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDto>handleTaskNotFoundException(TaskNotFoundException ex){
        UUID taskNotFoundId = ex.getId();
        String message =String.format("task with ID '%s' not found",taskNotFoundId);
        ErrorDto errorDto=new ErrorDto(message);
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }
    }

