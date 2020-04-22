package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Student;
import com.luv2code.springboot.cruddemo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("students")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student getById(@PathVariable int id) {
		Student student = studentService.getById(id);
		if(student == null) {
			throw new RuntimeException("Student id not found - "+id);
		}
		return student;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		
		//also just in case they pass an id in the json...set id to 0
		//this is to force a save of new item....instead of update
		
		student.setId(0);
		
		studentService.save(student);
		
		return student;
	}
}
