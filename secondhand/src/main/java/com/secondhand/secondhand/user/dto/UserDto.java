package com.secondhand.secondhand.user.dto;

import java.util.List;

import com.secondhand.secondhand.advertisement.dto.AdvertisementDto;

public class UserDto {

	private String mail;
	private String firstName;
	private String lastName;
	private String middleName;
	private List<UserDetailsDto> userDetailsDtos;
//	private List<AdvertisementDto> advertisementDtos;

	public UserDto(String mail, String firstName, String lastName, String middleName,
			List<UserDetailsDto> userDetailsDtos) {
	
		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.userDetailsDtos = userDetailsDtos;
//		this.advertisementDtos=advertisementDtos;
	}

	public UserDto(String mail2, String firstName2, String lastName2, String middleName2) {
	}

	public String getMail() {
		return mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public List<UserDetailsDto> getUserDetailsDtos() {
		return userDetailsDtos;
	}

//	public List<AdvertisementDto> getAdvertisementDtos() {
//		return advertisementDtos;
//	}

	
}
