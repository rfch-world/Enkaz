package com.secondhand.secondhand.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secondhand.secondhand.advertisement.dto.AdvertisementDto;
import com.secondhand.secondhand.advertisement.dto.CreateAdvertisementRequest;
import com.secondhand.secondhand.user.service.AdvertisementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/advertisement")
public class AdvertisementController {

	private final AdvertisementService advertisementService;

	public AdvertisementController(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}
	
	@PostMapping
	public ResponseEntity<AdvertisementDto> createAdvertisement(@Valid @RequestBody CreateAdvertisementRequest  request){
				
		return ResponseEntity.ok(advertisementService.createAdvertisement(request));
	}

}
