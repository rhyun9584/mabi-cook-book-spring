package com.j1001000.mabicookbook.dto;

import lombok.Getter;

@Getter
public class ExceptionResponseDto {
    private String errorMessage;

    public ExceptionResponseDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
