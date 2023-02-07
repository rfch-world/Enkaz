package com.company.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SharingDto {
    private String userId;
    private String address;
    private String personality;
    private String summary;
}
