package com.company.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class UserDto {

    private Long id;

    private String name;
}
