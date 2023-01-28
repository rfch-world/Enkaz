package com.secondhand.secondhand.user.dto;

public class UpdateUserDetailsRequest {

	private String proneNumber;
	private String address;
	private String city;
	private String country;
	private String postCode;
	public String getProneNumber() {
		return proneNumber;
	}
	public void setProneNumber(String proneNumber) {
		this.proneNumber = proneNumber;
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
