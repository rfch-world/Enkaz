package com.secondhand.secondhand.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secondhand.secondhand.user.dto.CreateUserRequest;
import com.secondhand.secondhand.user.dto.UpdateUserRequest;
import com.secondhand.secondhand.user.dto.UserDto;
import com.secondhand.secondhand.user.model.User;
import com.secondhand.secondhand.user.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {

		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id) {

		return ResponseEntity.ok(userService.getUserById(id));
	}

	@GetMapping("/exist/{id}")
	public ResponseEntity<Boolean> isUserIdExist(@PathVariable Integer id){
		return ResponseEntity.ok(userService.isUserIdExist(id));
	}
	
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest userRequest) {

		return ResponseEntity.ok(userService.createUser(userRequest));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @PathVariable Integer id,
			@RequestBody UpdateUserRequest updateUserRequest){
		return ResponseEntity.ok(userService.updateUser(updateUserRequest,id));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> deactiveUser(@PathVariable("id") Integer id){
		userService.deactivateUser(id);
		return ResponseEntity.ok().build();
		
	}
	
	@PatchMapping("/{id}/active")
	public ResponseEntity<Void> activeUser(@PathVariable("id") Integer id){
		userService.activeUser(id);
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	//bunlarin hamisina endpointler deyilir
}
