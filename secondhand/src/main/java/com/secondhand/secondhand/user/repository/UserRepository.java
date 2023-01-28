package com.secondhand.secondhand.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secondhand.secondhand.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
