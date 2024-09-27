package com.example.userscrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userscrud.entity.User;
import com.example.userscrud.exception.UserNotFoundException;
import com.example.userscrud.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(String email) {
		User user = userRepository.findByEmailAddress(email);
		if(user == null) {
			throw new UserNotFoundException("User with email : "+email+" doesn't exist.");
		}
		
		return user;
	}

	@Override
	public void deleteUser(String email) {
		User user = userRepository.findByEmailAddress(email);
		userRepository.delete(user);
	}

	@Override
	public int deleteUserByName(String name) {
		// 1 if success 0 if failure
		int count = userRepository.getUserCountByName(name);
		
		if (count > 1) {
			return 0;
		} else {
			User user = userRepository.findByName(name);
			userRepository.delete(user);
			return 1;
		}
	}

}
