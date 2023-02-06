package com.secondhand.secondhand.user.model;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	private LocalDateTime createdDate=null;
	private LocalDateTime updatedDate=null;

}
