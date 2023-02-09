package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "ip_address")
    private String ipAddress;

    @OneToMany(mappedBy = "user")
    List<SharingEntity> sharingEntities;

    @Column(name = "registration_date")
    LocalDateTime registrationDate;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    @BatchSize(size = 20)
    @Builder.Default
    @ToString.Exclude
    private Set<Authority> authorities = new HashSet<>();

    @PrePersist
    public void registrationDate(){
        registrationDate=LocalDateTime.now();
    }
}
