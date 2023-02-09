package com.company.service;

import com.company.dto.NumberOfAddressDto;
import com.company.entity.SharingEntity;
import com.company.entity.UserEntity;

import java.util.List;

public interface SharingService {

    SharingEntity save(SharingEntity user);

    List<SharingEntity> findAll();

    SharingEntity findById(Long userId);

    void deleteById(Long id);

    List<SharingEntity> findByUser(UserEntity userEntity);

    List<NumberOfAddressDto> topWreckList();
}
