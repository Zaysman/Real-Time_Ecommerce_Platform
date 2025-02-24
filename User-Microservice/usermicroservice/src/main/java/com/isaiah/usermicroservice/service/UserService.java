package com.isaiah.usermicroservice.service;

import com.isaiah.usermicroservice.object.User;
import com.isaiah.usermicroservice.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser.isPresent()) {
			throw new RuntimeException("Username already exists");
		}
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	public User readUserByUserid(long userid) {
		return userRepository.findByid(userid).orElse(null);
	}
	
	public User readUserByUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	
	@Transactional
	public void deleteUserByUserid(long userid) {
		userRepository.deleteByid(userid);
	}
	
	
	public boolean authenticateUser(User user) {
		//Initial null check. If user is null, we'll return false
		if(user == null) {
			return false;
		}
		
		boolean isAuthenticated = false;
		User existingUser = readUserByUserid(user.getId());
		
		//null check
		if(existingUser == null) {
			return false;
		}
		
		//Check the sent credentials against user data retrieved.
		if((user.getPassword().compareTo(existingUser.getPassword()) != 0 || user.getUsername().compareTo(existingUser.getUsername()) != 0)) {
			isAuthenticated = true;
		}
		
		return isAuthenticated;
	}

}
