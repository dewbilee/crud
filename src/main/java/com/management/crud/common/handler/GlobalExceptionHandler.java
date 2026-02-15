package com.management.crud.common.handler;

import com.management.crud.common.exception.ServiceException;
import com.management.crud.common.response.GlobalResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GlobalResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex) {

        GlobalResponse response = GlobalResponse.builder()
                .status(BAD_REQUEST.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now()).build();

        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GlobalResponse> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex) {

        GlobalResponse response = GlobalResponse.builder()
                .status(BAD_REQUEST.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now()).build();

        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        GlobalResponse response = GlobalResponse.builder()
                .status(BAD_REQUEST.value())
                .messages(errors)
                .timestamp(LocalDateTime.now()).build();

        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<GlobalResponse> handleServiceException(ServiceException ex) {

        GlobalResponse response = GlobalResponse.builder()
                .status(ex.getErrorCode().getHttpCode())
                .message(String.format("%s %s", ex.getErrorCode().getDescription(), ex.getMessage()))
                .timestamp(LocalDateTime.now()).build();

        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getHttpCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalResponse> handleGlobalException(Exception ex) {

        GlobalResponse response = GlobalResponse.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now()).build();

        return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
    }
}
