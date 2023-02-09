package com.company.service.impl;

import com.company.dto.NumberOfAddressDto;
import com.company.entity.SharingEntity;
import com.company.entity.UserEntity;
import com.company.exception.NotFoundException;
import com.company.repository.SharingRepository;
import com.company.service.SharingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SharingServiceImpl implements SharingService {

    private final SharingRepository sharingRepository;

    @Override
    public SharingEntity save(SharingEntity sharingEntity) {
        return sharingRepository.save(sharingEntity);
    }

    @Override
    public List<SharingEntity> findAll() {
        return sharingRepository.findAll();
    }

    @Override
    public SharingEntity findById(Long userId) {
        return sharingRepository.findById(userId)
                .orElseThrow(()->new NotFoundException("Can't find sharing with given id"));
    }

    @Override
    public void deleteById(Long id) {
        sharingRepository.deleteById(id);
    }

    @Override
    public List<SharingEntity> findByUser(UserEntity userEntity) {
        return sharingRepository.getAllByUser(userEntity);
    }

    @Override
    public List<NumberOfAddressDto> topWreckList() {
        return this.sharingRepository.countCityAndDistrict();
    }
}
