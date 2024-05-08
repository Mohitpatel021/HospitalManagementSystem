package com.HMSApp.Hospital.Management.System.Exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleArgsException(
    MethodArgumentNotValidException ex
  ) {
    Map<String, String> response = new HashMap<>();
    ex
      .getBindingResult()
      .getFieldErrors()
      .forEach(error -> {
        response.put(error.getField(), error.getDefaultMessage());
      });
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InternalServerException.class)
  public ResponseEntity<?> internalServerException(InternalServerException ex) {
    Map<String, String> response = new HashMap<>();
    response.put("message", ex.getLocalizedMessage());
    //	        response.put("Status",ex.getStatus());
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(response);
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<?> userNotFoundException(UsernameNotFoundException ex) {
    Map<String, String> response = new HashMap<String, String>();
    response.put("message", ex.getLocalizedMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler(AuthenticationFailedException.class)
  public ResponseEntity<?> AuthenticationFailed(
    AuthenticationFailedException ex
  ) {
    Map<String, String> response = new HashMap<String, String>();
    response.put("message", ex.getLocalizedMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}
