package com.company.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
public class SharingEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "address")
    private String address;

    @Lob
    @Column(name = "personality")
    private String personality;

    @Lob
    @Column(name = "summary")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
