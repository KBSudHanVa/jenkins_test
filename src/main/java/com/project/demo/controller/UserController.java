package com.project.demo.controller;

//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
//	@Autowired
//	UserRepo repo;

	@GetMapping("/name")
	public String name() {
		return "sudhanva-v6";
	}
	
//	@GetMapping("/users")
//	public List<Users> users() {
//		return repo.findAll();
//	}
	
}
