package com.luv2code.springboot.cruddemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.ProductsRepository;
import com.luv2code.springboot.cruddemo.dao.RegisterRepository;
import com.luv2code.springboot.cruddemo.entity.Products;
import com.luv2code.springboot.cruddemo.entity.Register;

@Service
public class ProductsServicesImplementation implements ProductsServices{
	
	//products
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@Override
	public List<Products> findAll() {
		
		return productsRepository.findAll();
	}

	@Override
	public Products getById(int productId) {
		Optional<Products> result = productsRepository.findById(productId);
		
		Products products;
		if (result.isPresent()) {
			products = result.get();
		}else {
			throw new RuntimeException("id not found " + productId);
		}
		return products;
	}
	
	@Override
	public void deleteProducts(int productId) {
		productsRepository.deleteById(productId);
	}
	
	@Override
	public void saveProduct(Products products) {
		productsRepository.save(products);
	}

	

	//Register

	@Override
	public List<Register> findAllUsers() {
		return registerRepository.findAll();
	}

	@Override
	public Register getByIdUser(String email) {
		Optional<Register> result = registerRepository.findById(email);
		
		Register register;
		if (result.isPresent()) {
			register = result.get();
		} else {
			throw new RuntimeException("email not found " + email);
		}
		return register;
	}

	@Override
	public void deleteUser(String email) {
		registerRepository.deleteById(email);
	}

	@Override
	public void saveUser(Register register) {
		registerRepository.save(register);
	}
}
