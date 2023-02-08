package com.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class SharingDto {
    private String userId;

    private String address;

    private String city;

    private String nameSurname;

    private String district;

    private String neighborhood;

    private String street;

    private String informationSource;
}
