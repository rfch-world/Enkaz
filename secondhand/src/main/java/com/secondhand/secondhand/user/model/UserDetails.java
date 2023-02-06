package com.secondhand.secondhand.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	private  String phoneNumber;
	private  String address;
	private  String city;
	private  String country;
	private  String postCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id" , nullable = false)
	private  User user;
	

	public UserDetails(Integer id, String phoneNumber, String address, String city, String country, String postCode, User user) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
		this.user = user;
	}
	public UserDetails(String phoneNumber, String address, String city, String country, String postCode, User user) {
		
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
		this.user = user;
	}
	public UserDetails() {
	
	}

	public Integer getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getPostCode() {
		return postCode;
	}
	

	public User getUser() {
		return user;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	

}
