package com.example.crud.ServiceImpl;

import com.example.crud.DTO.UserDTO;
import com.example.crud.Entity.User;

public interface UserService {

	public User getUser(Integer id);
	
	public String saveOrUpdateUser(UserDTO userDTO);
	
	public String removeUser(Integer id);
	
}
