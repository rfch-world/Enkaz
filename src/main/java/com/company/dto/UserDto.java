package com.company.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Isim bos olamaz")
    private String name;

    @NotBlank(message = "Parola bos olamaz")
    @Size(min = 3,message = "Parola 4 ve ya daha cok sembolden olusmali ")
    private String password;
}
