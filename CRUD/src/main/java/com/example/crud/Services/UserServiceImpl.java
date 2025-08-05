package com.example.crud.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.DTO.UserDTO;
import com.example.crud.Entity.User;
import com.example.crud.Repository.UserRepository;
import com.example.crud.ServiceImpl.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public String saveOrUpdateUser(UserDTO userDTO) {
		if(userDTO != null) {
			Optional<User> user = userRepository.findById(userDTO.getId());
			User userDetails = user.orElse(new User());
			System.out.println(userDetails);
			userDetails.setUserName(userDTO.getUserName());
			userDetails.setUserAddress(userDTO.getUserAddress());
			userRepository.save(userDetails);
			return "User data saved successfully";
		}
		return "its failed";
	}

	@Override
	public User getUser(Integer id) {
		if (id != null) {
			Optional<User> user = userRepository.findById(id);
			return user.orElseGet(null);
		}
		return null;
	}

	@Override
	public String removeUser(Integer id) {
		if(id != null) {
			User user = userRepository.findById(id).get();
			if(user != null) {
				userRepository.delete(null);
				return "User removed";
			}
		}
		return "Its failed";
	}
}
