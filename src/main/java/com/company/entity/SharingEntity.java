package com.company.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sharing")
@Getter
@Setter
@NoArgsConstructor
public class SharingEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "street")
    private String street;

    @Column(name = "information_source")
    private String informationSource;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
