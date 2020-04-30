package com.tyss.cg.springbootdatajpa.services;

import java.util.List;

import com.tyss.cg.springbootdatajpa.entity.Products;
import com.tyss.cg.springbootdatajpa.entity.Register;

public interface ProductsServices {
	
	
	//Products
	public List<Products> findAll();
	
	public Products getById(int productId);
	
	public void deleteProducts(int productId);
	
	public boolean saveProduct(Products products);	
	
	
	//Register
	public List<Register> findAllUsers();
	
	public Register getByIdUser(String email);
	
	public void deleteUser(String email);
	
	public boolean saveUser(Register register);	
	
	Register login(String email, String password);
	
}
