package com.secondhand.secondhand.advertisement.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.secondhand.secondhand.user.model.Advertisement;

@Component
public class AdvertisemenDtoConverter {
	
	
	public AdvertisementDto convert(Advertisement from) {
		
		return new AdvertisementDto(from.getDescription(),from.getTitle(),from.getPrice(),from.getHashtags());
		
	}
	
	public List<AdvertisementDto> convert(List<Advertisement> from){
		return from.stream().map(this:: convert).collect(Collectors.toList());
		
	}

}
