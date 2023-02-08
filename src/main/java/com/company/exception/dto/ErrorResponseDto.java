package com.company.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDto {
    String message;
    HttpStatus httpStatus;
    ZonedDateTime dateTime;
}
