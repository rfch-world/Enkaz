package com.secondhand.secondhand.advertisement.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateAdvertisementRequest {
	
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 50,message = "Maximum value must be 50 at least")
	private String title;
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 100,message = "Maximum value must be 100 at least")
	private String description;
	@NotNull(message = "Must be written") 
	@Max(value = 1000,message = "Maximum value must be 1000" )
	private Double price; //TODO change it by BigDecimol
	@NotBlank(message = "Must be written") 
	private Integer userId;
	@NotBlank(message = "Must be written") 
	@Size(min = 2,message = "Minimum value must be 2 at least")
	@Size(max = 100,message = "Maximum value must be 100 at least")
	private String hashtags;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getHashtags() {
		return hashtags;
	}
	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}
	
	
	
	

}
