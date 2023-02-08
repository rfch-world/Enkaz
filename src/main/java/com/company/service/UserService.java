package com.company.service;

import com.company.dto.RegistrationDto;
import com.company.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity findByName(String name);

    UserEntity save(UserEntity user);

    List<UserEntity> findAll();

    UserEntity findById(Long userId);

    void deleteById(Long id);

    void register(RegistrationDto dto);
}
