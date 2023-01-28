package com.secondhand.secondhand.user.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secondhand.secondhand.user.dto.CreateUserDetailsRequest;
import com.secondhand.secondhand.user.dto.UpdateUserDetailsRequest;
import com.secondhand.secondhand.user.dto.UserDetailsDto;
import com.secondhand.secondhand.user.service.UserDetailsService;

@RestController
@RequestMapping("/v1/userdetails")
public class UserDetailsController {

	private final UserDetailsService userDetailsService;

	public UserDetailsController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;

	}
	
	@PostMapping
	public ResponseEntity<UserDetailsDto> createUserDetails(@Valid @RequestBody CreateUserDetailsRequest request){
		
		return ResponseEntity.ok(userDetailsService.createUserDetails(request));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDetailsDto> updateUserDetails(@Valid @PathVariable Integer id, @RequestBody UpdateUserDetailsRequest request ){
		
		return ResponseEntity.ok(userDetailsService.updateUserDetails(id, request));
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserDetails(@PathVariable Integer id){
		userDetailsService.deleteUserDetails(id);
		return  ResponseEntity.ok().build();
		
		
	}

}
