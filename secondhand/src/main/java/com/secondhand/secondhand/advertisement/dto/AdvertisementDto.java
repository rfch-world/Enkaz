package com.secondhand.secondhand.advertisement.dto;

import java.time.LocalDateTime;

public class AdvertisementDto {

	private Integer userId;
	private String title;
	private String description;
	private Double price;// TODO change it by BigDecimol
	private LocalDateTime creationDate;
	private LocalDateTime lastModifiedDate;
	private String hashtags;

	public AdvertisementDto(String title, String description, Double price, String hashtags) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.hashtags = hashtags;
	}

	public AdvertisementDto() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

}
