package com.luv2code.springboot.cruddemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.BooksRepository;
import com.luv2code.springboot.cruddemo.entity.Books;

@Service
public class BooksServicesImpl implements BooksServices{

	@Autowired
	private BooksRepository booksRepository;
	
	
	@Override
	public List<Books> findAll() {
		return booksRepository.findAll();
	}

	@Override
	public Books getById(int id) {
		Optional<Books> result = booksRepository.findById(id);
		
		Books books = null;
		if (result.isPresent()) {
			books = result.get();
		} else {
			throw new RuntimeException("no book bi id " + id);
		}
		
		return books;
	}

	@Override
	public void save(Books books) {
		booksRepository.save(books);
		
	}

	@Override
	public void deleteById(int id) {
		booksRepository.deleteById(id);
	}

}
