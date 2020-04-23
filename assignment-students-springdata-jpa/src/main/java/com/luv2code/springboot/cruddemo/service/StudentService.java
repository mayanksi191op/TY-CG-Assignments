package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student getById(int id);
	
	public void save(Student student);

	void deleteById(int id);
}
