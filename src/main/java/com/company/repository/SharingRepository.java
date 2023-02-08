package com.company.repository;

import com.company.entity.SharingEntity;
import com.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharingRepository extends JpaRepository<SharingEntity,Long> {
    List<SharingEntity> getAllByUser(UserEntity userEntity);
}
