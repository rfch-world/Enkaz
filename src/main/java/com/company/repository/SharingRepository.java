package com.company.repository;

import com.company.dto.NumberOfAddressDto;
import com.company.entity.SharingEntity;
import com.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharingRepository extends JpaRepository<SharingEntity,Long> {
    List<SharingEntity> getAllByUser(UserEntity userEntity);

    @Query(value = "SELECT new com.company.dto.NumberOfAddressDto(se.city, COUNT(se.id)) " +
            "FROM SharingEntity se " +
            "GROUP BY se.city ORDER BY COUNT(se.id) desc")
    List<NumberOfAddressDto> countDistrict();
}
