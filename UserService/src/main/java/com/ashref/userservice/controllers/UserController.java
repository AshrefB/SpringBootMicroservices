package com.ashref.userservice.controllers;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashref.userservice.dto.UserDTO;
import com.ashref.userservice.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	private Environment environment;
	private UserService userService;
	
	@GetMapping({"", "/", "/welcome"})
	public String welcome() {
		return "UserService running on port: "+environment.getProperty("local.server.port");
	}
	
	@PostMapping("/add")
	public UserDTO addUser(@RequestBody UserDTO userDTO ) {
		return userService.addUser(userDTO);
	}
	
}
