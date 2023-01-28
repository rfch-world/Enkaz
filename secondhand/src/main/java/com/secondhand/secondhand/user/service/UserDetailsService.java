package com.secondhand.secondhand.user.service;

import org.springframework.stereotype.Service;

import com.secondhand.secondhand.user.dto.CreateUserDetailsRequest;
import com.secondhand.secondhand.user.dto.UpdateUserDetailsRequest;
import com.secondhand.secondhand.user.dto.UserDetailsDto;
import com.secondhand.secondhand.user.dto.UserDetailsDtoConverter;
import com.secondhand.secondhand.user.exception.UserDetailsNotFoundException;
import com.secondhand.secondhand.user.model.User;
import com.secondhand.secondhand.user.model.UserDetails;
import com.secondhand.secondhand.user.repository.UserDetailsRepository;

@Service
public class UserDetailsService {

	private final UserDetailsRepository userDetailsRepository;
	private final UserService userService;
	private final UserDetailsDtoConverter converter;
	

	public UserDetailsService(UserDetailsRepository userDetailsRepository, UserService userService, UserDetailsDtoConverter converter) {
		this.userDetailsRepository = userDetailsRepository;
		this.userService = userService;
		this.converter = converter;
		
	}
	
	public UserDetailsDto createUserDetails(final CreateUserDetailsRequest request) {
		User user=userService.findUserById(request.getUserId());
		
		UserDetails userDetails=new UserDetails(
				request.getPhoneNumber(),
				request.getAddress(),
				request.getCity(),
				request.getCountry(),
				request.getPostCode(),
				user);
		
		return converter.convert(userDetailsRepository.save(userDetails));
		
	}
	
	public UserDetailsDto updateUserDetails(final Integer userDetailsId,  final UpdateUserDetailsRequest request) {
		UserDetails userDetails=findUserDetailsById(userDetailsId);
		
		UserDetails updateUserDetails=new UserDetails(
				userDetails.getId(),
				request.getProneNumber(),
				request.getAddress(),
				request.getCity(),
				request.getCountry(),
				request.getPostCode(),
				userDetails.getUser());
		
		return converter.convert(userDetailsRepository.save(updateUserDetails));
		
	}
	
	
	public void deleteUserDetails(final Integer id) {
		findUserDetailsById(id);
		
		userDetailsRepository.deleteById(id);
	}
	
	private UserDetails findUserDetailsById(final Integer userDetailsId) {
		
		return userDetailsRepository.findById(userDetailsId)
				.orElseThrow(() -> new UserDetailsNotFoundException("User couldn't be found by following id: " +userDetailsId));
		
	}

}
