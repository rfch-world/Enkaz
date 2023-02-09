package com.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SharingDto {
    private String userId;

    private String address;

    private String city;

    private String nameSurname;

    private String district;

    private String neighbourhood;

    private String street;

    private String informationSource;
}
