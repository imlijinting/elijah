package com.example.elijah.web;

import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

  @ExceptionHandler(Exception.class)
  public String handle(Exception ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public String handle(MethodArgumentNotValidException ex) {
    return ex.getBindingResult().getAllErrors()
        .stream()
        .map(objectError -> {
          if (objectError.getClass() == FieldError.class) {
            String field = ((FieldError) objectError).getField();
            return String.join(":", field, objectError.getDefaultMessage());
          }
          return String.join(objectError.getObjectName(), objectError.getDefaultMessage());
        }).collect(Collectors.joining(StringUtils.LF));
  }
}
