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

import com.luv2code.springboot.cruddemo.entity.Books;
import com.luv2code.springboot.cruddemo.services.BooksServices;

@RestController
@RequestMapping("/api")
public class BooksRestController {
	
	@Autowired
	private BooksServices booksServices;
	
	@GetMapping("/books")
	public List<Books> findAll(){
		return booksServices.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Books getById(@PathVariable int id) {
		Books books = booksServices.getById(id);
		if (books == null) {
			throw new RuntimeException("id not found " + id);
		}
		return books;
	}
	
	@PostMapping("/books")
	public Books addBooks(@RequestBody Books books) {
		books.setId(0);
		
		booksServices.save(books);
		
		return books;
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBooks(@PathVariable int id) {
		Books books = booksServices.getById(id);
		
		if (books == null) {
			throw new RuntimeException("id not found " + id);
		}
		
		booksServices.deleteById(id);
		return "deleted";
	}
	
	@PutMapping("/books")
	public Books updateBooks(@RequestBody Books books) {
		booksServices.save(books);
		return books;
	}
	
}
