package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Users;
import com.project.demo.repo.UserRepo;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepo repo;

	@GetMapping("/name")
	public String name() {
		return "sudhanva-v5";
	}
	
	@GetMapping("/users")
	public List<Users> users() {
		return repo.findAll();
	}
	
}
