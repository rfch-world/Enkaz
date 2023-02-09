package com.company.dto;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumberOfAddressDto {

    @Column(name = "district")
    private String district;

    @Column(name = "number")
    private Long number;

}
