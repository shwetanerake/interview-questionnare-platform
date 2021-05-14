package com.platform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.user.User;
import com.platform.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}
	
	public boolean userIsPresent(Long userId) {
		return userRepository.findById(userId).isPresent();
	}

	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
}
