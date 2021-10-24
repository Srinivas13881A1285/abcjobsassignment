package com.codebyamir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebyamir.model.User;
import com.codebyamir.repository.UserRepository;

import java.util.Optional;

@Service("userService")
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public Optional findUserByResetToken(String resetToken) {
		return userRepository.findUserByConfirmationToken(resetToken);
	}

	public Optional findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}