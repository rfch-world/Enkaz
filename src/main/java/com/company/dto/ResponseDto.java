package com.company.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class ResponseDto {
    private String data;
    private HttpStatus httpStatus;
}
