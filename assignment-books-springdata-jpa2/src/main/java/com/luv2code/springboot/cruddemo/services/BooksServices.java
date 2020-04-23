package com.luv2code.springboot.cruddemo.services;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Books;


public interface BooksServices {

	public List<Books> findAll();
	
	public Books getById(int id);
	
	public void save(Books books);

	void deleteById(int id);
}
