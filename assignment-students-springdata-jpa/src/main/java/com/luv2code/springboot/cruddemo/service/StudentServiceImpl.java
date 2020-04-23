package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.StudentRepository;
import com.luv2code.springboot.cruddemo.entity.Student;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}


	@Override
	public Student getById(int id) {

		Optional<Student> result = studentRepository.findById(id);
		
		Student student = null;
		if (result.isPresent()) {

		student = result.get();
		}
		else {
			//we didnt fint the employee
			throw new RuntimeException("didnt find the employeeId- " + id);
		}
		return student;
	}
	
	@Override
	public void save(Student student) {
		 studentRepository.save(student);
	}
	
	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}
	
}
