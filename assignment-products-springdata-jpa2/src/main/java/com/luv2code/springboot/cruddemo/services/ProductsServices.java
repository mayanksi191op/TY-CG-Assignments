package com.luv2code.springboot.cruddemo.services;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Products;
import com.luv2code.springboot.cruddemo.entity.Register;

public interface ProductsServices {
	
	
	//Products
	public List<Products> findAll();
	
	public Products getById(int productId);
	
	public void deleteProducts(int productId);
	
	public void saveProduct(Products products);	
	
	
	//Register
	public List<Register> findAllUsers();
	
	public Register getByIdUser(String email);
	
	public void deleteUser(String email);
	
	public void saveUser(Register register);	
	
}
