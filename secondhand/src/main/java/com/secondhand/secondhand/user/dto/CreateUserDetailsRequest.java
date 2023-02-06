package com.secondhand.secondhand.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateUserDetailsRequest {

	@NotBlank(message = "Email must be written!")
	private Integer userId;
	@NotBlank(message = "Email must be written!")
	@Pattern(regexp = "((\\\\(\\\\d{3}\\\\ ?)|(\\\\d{3}-))?\\\\d{3}-\\\\d{4}",message = "Phone pattern must be :000-000-0000")
	private String phoneNumber;
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 100,message = "Maximum value must be 100 at least")
	private String address;
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 50,message = "Maximum value must be 50 at least")
	private String city;
	@NotBlank(message = "Must be written")
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 50,message = "Maximum value must be 50 at least")
	private String country;
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 20,message = "Maximum value must be 20 at least")
	private String postCode;
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String proneNumber) {
		this.phoneNumber = proneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}


