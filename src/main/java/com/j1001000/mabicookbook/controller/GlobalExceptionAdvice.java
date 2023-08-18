package com.j1001000.mabicookbook.controller;

import com.j1001000.mabicookbook.dto.ExceptionResponseDto;
import com.j1001000.mabicookbook.exception.CollectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler({
            CollectNotFoundException.class,
    })
    public ResponseEntity<ExceptionResponseDto> notFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponseDto(e.getMessage()));
    }
}
