package com.luv2code.springboot.cruddemo.services;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Products;

public interface ProductsServices {
	
	public List<Products> findAll();
	
	public Products getById(int productId);
	
	public void deleteProducts(int productId);
	
	public void saveProduct(Products products);	
	
}
