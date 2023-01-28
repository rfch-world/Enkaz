package com.secondhand.secondhand.user.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String mail;
	private String firstName;
	private String lastName;
	private String middleName;
	private Boolean isActive;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "user" })
	private Set<UserDetails> userDetails = new HashSet<>();// set tekrarlanmayan elementleri barindirir ona gore set
															// yazmishiq

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "user" })
	private Set<Advertisement> advertisements;

	// update ishledir
	public User(Integer id, String mail, String firstName, String lastName, String middleName, Boolean isActive) {

		this.id = id;
		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.isActive = isActive;

	}
//	/createuseri ishledir

	public User(String mail, String firstName, String lastName, String middleName) {

		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
//		this.isActive = isActive;

	}

	public User(Integer id, String mail, String firstName, String lastName, String middleName, Boolean isActive,
			Set<UserDetails> userDetails, Set<Advertisement> advertisements) {
		super();
		this.id = id;
		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.isActive = isActive;
		this.userDetails = userDetails;
		this.advertisements = advertisements;
	}
//
//	public User(Integer id, String mail, String firstName, String lastName, String middleName) {
//		this.id = id;
//		this.mail = mail;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.middleName = middleName;
//	}

	public User() {
	}

	public Integer getId() {
		return id;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<UserDetails> getUserDetails() {
		return userDetails;
	}

	public Set<Advertisement> getAdvertisements() {
		return advertisements;
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
