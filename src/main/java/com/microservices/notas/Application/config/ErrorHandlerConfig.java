package com.microservices.notas.Application.config;


import com.microservices.notas.Application.exceptions.GeneralServiceException;
import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Application.exceptions.ResourceNotFoundException;
import com.microservices.notas.Application.utils.WrapperResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@RestController

public class ErrorHandlerConfig extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getAllErrors().stream().map(e -> {
            return e.getDefaultMessage().toString().concat(", ");
        }).collect(Collectors.joining());
        WrapperResponse<Void> response = new WrapperResponse<>(false, message, null);
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<WrapperResponse<Void>> all(Exception e, WebRequest request){
        WrapperResponse<Void> response = new WrapperResponse<>(false, "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IncorrectResourceRequestException.class)
    public ResponseEntity<WrapperResponse<Void> > validateServiceException(IncorrectResourceRequestException e, WebRequest request){
        WrapperResponse<Void> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<WrapperResponse<Void> > noDataFoundException(ResourceNotFoundException e, WebRequest request){
        WrapperResponse<Void> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<WrapperResponse<Void> > generalServiceException(GeneralServiceException e, WebRequest request){
        WrapperResponse<Void> response = new WrapperResponse<>(false, "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}