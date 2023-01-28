package com.secondhand.secondhand.user.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.secondhand.secondhand.user.dto.CreateUserRequest;
import com.secondhand.secondhand.user.dto.UpdateUserRequest;
import com.secondhand.secondhand.user.dto.UserDto;
import com.secondhand.secondhand.user.dto.UserDtoConverter;
import com.secondhand.secondhand.user.exception.UserIsNotActiveException;
import com.secondhand.secondhand.user.exception.UserNotFoundException;
import com.secondhand.secondhand.user.model.User;
import com.secondhand.secondhand.user.repository.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;
	private final UserDtoConverter userDtoConverter;

	public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
		this.userRepository = userRepository;
		this.userDtoConverter = userDtoConverter;

	}

	public List<User> getAllUsers() {

		return userRepository.findAll();

	}

	public Optional<User> getUserById(Integer id) {
		User user = findUserById(id);
		return userRepository.findById(id);

	}

	public UserDto createUser(final CreateUserRequest userRequest) {

		User user = new User(userRequest.getMail(),
				userRequest.getFirstName(),
				userRequest.getLastName(),
				userRequest.getMiddleName());
		
				user.setIsActive(false);
		
		return userDtoConverter.convert(userRepository.save(user));
	}

	public UserDto updateUser(final UpdateUserRequest updateUserRequest, final Integer id) {

		User user = findUserById(id);
		if (!user.getIsActive()) {
			logger.warn(String.format("The user is not active for updating!,  User id : %s" + id));
			throw new UserIsNotActiveException();
		}
		User updatedUser = new User(user.getId(),
				user.getMail(),
				updateUserRequest.getFirstName(),
				updateUserRequest.getLastName(),
				updateUserRequest.getMiddleName(),
				user.getIsActive());
		

		return userDtoConverter.convert(userRepository.save(updatedUser));
	}

	public void deactivateUser(Integer id) {
//eger bu metod alinmasa konstraktor yarat ver butun melumatlari yeni obyektin ichine menimsedib ele konstraktor olduqu uchun ede bilessen
		User user = findUserById(id);

		user.setIsActive(false);

		userRepository.save(user);

	}

	public void activeUser(Integer id) {
		User user = findUserById(id);

		user.setIsActive(true);

		userRepository.save(user);

	}

	public void deleteUser(Integer id) {

		if (doesUserExist(id)) {
			userRepository.deleteById(id);

		} else {
			throw new UserNotFoundException("User couldn't be found by following id: " + id);
		}

	}

	public Boolean isUserIdExist(Integer id) {

		return userRepository.existsById(id);
	}


// bu method tekrar formada kodu yazmamaq uchun 1 defe yaradilib bu setr kodlara ehtiyac olduqu anda method sheklinde istifade olunacaqdir
	protected User findUserById(Integer id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User couldn't be found by following id: " + id));
	}

	private boolean doesUserExist(Integer id) {

		return userRepository.existsById(id);
	}

}
