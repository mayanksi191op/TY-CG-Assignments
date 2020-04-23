package com.luv2code.springboot.cruddemo.services;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Users;

public interface UsersServices {
	
	public List<Users> findAll();
	
	public Users getById(int id);
	
	public void deleteUser(int id);
	
	public void save(Users users);
}
