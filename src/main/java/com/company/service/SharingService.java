package com.company.service;

import com.company.entity.SharingEntity;
import com.company.entity.UserEntity;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface SharingService {

    SharingEntity save(SharingEntity user);

    List<SharingEntity> findAll();

    SharingEntity findById(Long userId);

    void deleteById(Long id);

    List<SharingEntity> findByUser(UserEntity userEntity);
}
