package com.secondhand.secondhand.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondhand.secondhand.user.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

}
