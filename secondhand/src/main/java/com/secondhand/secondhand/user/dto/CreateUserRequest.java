package com.secondhand.secondhand.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateUserRequest {


	@Email(message = "Write email correctly!")
	@NotBlank(message = "Email must be written!")
	@Size(max = 50,message = "Maximum value must be 50 at least")
	private String mail;
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 30,message = "Maximum value must be 30 at least")
	private String firstName;
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 30,message = "Maximum value must be 30 at least")
	private String lastName;
	private String middleName;

	public CreateUserRequest(String mail, String firstName, String lastName, String middleName) {
		super();
		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
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
	}}
