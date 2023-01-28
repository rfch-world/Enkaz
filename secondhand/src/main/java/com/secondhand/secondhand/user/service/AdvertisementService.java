package com.secondhand.secondhand.user.service;

import org.springframework.stereotype.Service;

import com.secondhand.secondhand.advertisement.dto.AdvertisemenDtoConverter;
import com.secondhand.secondhand.advertisement.dto.AdvertisementDto;
import com.secondhand.secondhand.advertisement.dto.CreateAdvertisementRequest;
import com.secondhand.secondhand.user.model.Advertisement;
import com.secondhand.secondhand.user.model.User;
import com.secondhand.secondhand.user.repository.AdvertisementRepository;

@Service
public class AdvertisementService {
	
	private final AdvertisementRepository advertisementRepository;
	private final AdvertisemenDtoConverter converter;
	private final UserService userService;
	public AdvertisementService(AdvertisementRepository advertisementRepository, AdvertisemenDtoConverter converter, UserService userService) {
		this.advertisementRepository = advertisementRepository;
		this.converter = converter;
		this.userService = userService;
	
	}

	public AdvertisementDto createAdvertisement(final CreateAdvertisementRequest request) {

			User user =userService.findUserById(request.getUserId());
		
		Advertisement advertisement = new Advertisement(request.getTitle(),
				request.getDescription(),
				request.getPrice(),
				request.getHashtags(),
				user);
		
		return converter.convert(advertisementRepository.save(advertisement));

	}
}
