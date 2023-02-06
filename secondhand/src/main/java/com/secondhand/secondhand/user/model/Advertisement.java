package com.secondhand.secondhand.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

//@Document(indexName = "advertisement")
@Entity(name = "advertisement")
public class Advertisement {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	private String title; // keyword varsa daha rahat ede bilirik
	private String description;
	private Double price;// TODO change it by BigDecimol
	private LocalDateTime creationDate;// date daha sonra local date time ile de evez ede bilersen orda ele dediler
	private LocalDateTime lastModifiedDate;
	// TODO change it by Set<String>
	private String hashtags; // set tekrarlanmayan elementleri barindirir ona gore set yazmishiq

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
//	@LazyCollection(LazyCollectionOption.FALSE)
	private User user;
	public Advertisement() {
	}

	public Advertisement(String title, String description, Double price, String hashtags,User user) {

		this(title, description, price, LocalDateTime.now(), LocalDateTime.now(), hashtags,user);
	}

	public Advertisement(String title, String description, Double price, LocalDateTime date, LocalDateTime date2,
			String hashtags,User user) {

		this.title = title;
		this.description = description;
		this.price = price;
		this.creationDate = date;
		this.lastModifiedDate = date2;
		this.hashtags = hashtags;
		this.user=user;
	}

	public Advertisement(String id, String title, String description, Double price, LocalDateTime creationDate,
			LocalDateTime lastModifiedDate, String hashtags) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.creationDate = creationDate;
		this.lastModifiedDate = lastModifiedDate;
		this.hashtags = hashtags;
	}

	public User getUser() {
		return user;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

//	public Integer getUserId() {
//		return userId;
//	}

	public String getHashtags() {
		return hashtags;
	}

	

	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", creationDate=" + creationDate + ", lastModifiedDate=" + lastModifiedDate + ", hashtags=" + hashtags
				+ ", user=" + user + "]";
	}

}
