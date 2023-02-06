package com.secondhand.secondhand.user.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.secondhand.secondhand.user.model.User;
@Component
public class UserDtoConverter {

	private final UserDetailsDtoConverter converter;
//	private final AdvertisemenDtoConverter converterAdvert;

	public UserDtoConverter(UserDetailsDtoConverter converter) {
		this.converter = converter;
//		this.converterAdvert = converter2;
	}

	public UserDto convert(User from) {
		return new UserDto(from.getMail(), from.getFirstName(), from.getLastName(), from.getMiddleName(),
				converter.convert(new ArrayList<>(from.getUserDetails())));
	}

	public List<UserDto> convert(List<User> fromList) {

		return fromList.stream().map(this::convert).collect(Collectors.toList());
	}
}
