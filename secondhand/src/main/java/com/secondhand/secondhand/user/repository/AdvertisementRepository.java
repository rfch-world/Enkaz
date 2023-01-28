package com.secondhand.secondhand.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondhand.secondhand.user.model.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, String> {

}
