package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.DTO.UserDTO;
import com.example.crud.Entity.User;
import com.example.crud.ServiceImpl.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "getById/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") Integer id) {
		User user = userService.getUser(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping(value = "saveOrUpdateUser")
	public ResponseEntity<String> saveOrUpdateUser(@RequestBody UserDTO userDto) {
		String response = userService.saveOrUpdateUser(userDto);
		return ResponseEntity.ok(response);
	}

	@PatchMapping(value = "removeUser/{id}")
	public ResponseEntity<String> removeUser(@PathVariable(value = "id") Integer id) {
		String response = userService.removeUser(id);
		return ResponseEntity.ok(response);
	}
}
