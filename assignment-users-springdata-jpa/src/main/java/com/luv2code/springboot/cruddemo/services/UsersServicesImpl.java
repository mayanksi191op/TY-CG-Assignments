package com.luv2code.springboot.cruddemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.UsersRepository;
import com.luv2code.springboot.cruddemo.entity.Users;

@Service
public class UsersServicesImpl implements UsersServices{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public Users getById(int id) {
		Optional<Users> result = usersRepository.findById(id);
		
		Users users;
		if (result.isPresent()) {
			users = result.get();
		} else {
			throw new RuntimeException("id not found " + id);
		}
		
		return users;
	}

	@Override
	public void deleteUser(int id) {			
		usersRepository.deleteById(id);
	}

	@Override
	public void save(Users users) {
		usersRepository.save(users);
	}

}
