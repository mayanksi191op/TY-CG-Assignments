package com.luv2code.springboot.cruddemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.luv2code.springboot.cruddemo.entity.Student;

public class InsertStudent {
	
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
				
		Student student = new Student();
		student.setAge(12);
		student.setEmail("mayanksi191@gmail");
		student.setFirstName("Mayank");
		student.setLastName("Singh");
		list.add(student);
		
		
	}
	
}
