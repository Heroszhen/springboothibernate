package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository ur;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return this.ur.findAll();
	}
	
	@PostMapping(path="/users")
	public int createUser(@RequestBody User user) {
		this.ur.save(user);
		return 1;
	}
}
