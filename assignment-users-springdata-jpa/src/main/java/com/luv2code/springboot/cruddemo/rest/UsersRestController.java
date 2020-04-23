package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Users;
import com.luv2code.springboot.cruddemo.services.UsersServices;

@RestController
@RequestMapping("/api")
public class UsersRestController {
	
	@Autowired
	private UsersServices usersServices;
	
	@GetMapping("/users")
	public List<Users> viewAll() {
		return usersServices.findAll();
	}
	
	@GetMapping("users/{id}")
	public Users getById(@PathVariable int id) {
		Users users = usersServices.getById(id);
		
		if (users == null) {
			throw new RuntimeException("id not found " + id);
		}
		return users;
	}
	
	@PostMapping("/users")
	public Users saveUser(@RequestBody Users users) {
		
		users.setId(0);
		usersServices.save(users);
		
		return users;
	}
	
	@PutMapping("/users")
	public String updateUsers(@RequestBody Users users) {
		usersServices.save(users);
		return "updated";
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUsers(@PathVariable int id) {
		Users users = usersServices.getById(id);
		
		if (users == null) {
			throw new RuntimeException("id not found " + id);
		}
		usersServices.deleteUser(id);
		return "deleted";
	}
}
