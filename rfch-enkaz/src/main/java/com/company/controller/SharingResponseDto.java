package com.company.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SharingResponseDto {
    private Long id;
    private String userId;
    private String address;
    private String personality;
    private String summary;
}
