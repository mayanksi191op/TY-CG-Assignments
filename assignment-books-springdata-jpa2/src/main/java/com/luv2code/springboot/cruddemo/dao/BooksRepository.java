package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{

}
