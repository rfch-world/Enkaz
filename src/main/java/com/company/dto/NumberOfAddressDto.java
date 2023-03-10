package com.company.dto;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumberOfAddressDto {

    @Column(name = "city")
    private String city;

    @Column(name = "number")
    private Long number;

}
