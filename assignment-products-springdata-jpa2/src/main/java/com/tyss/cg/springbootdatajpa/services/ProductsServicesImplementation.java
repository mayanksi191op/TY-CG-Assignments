package com.tyss.cg.springbootdatajpa.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.cg.springbootdatajpa.dao.ProductsRepository;
import com.tyss.cg.springbootdatajpa.dao.RegisterRepository;
import com.tyss.cg.springbootdatajpa.entity.Products;
import com.tyss.cg.springbootdatajpa.entity.Register;

@Service
public class ProductsServicesImplementation implements ProductsServices{
	
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	
	//products
	
	@Override
	public List<Products> findAll() {
		
		return productsRepository.findAll();
	}

	@Override
	public Products getById(int productId) {
		Optional<Products> result = productsRepository.findById(productId);
		
		Products products =null;
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
	public boolean saveProduct(Products products) {
		Products products2 = productsRepository.save(products);
		
		if (products2 == null) {
			return false;
		}else {
			return true;
		}
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
	public boolean saveUser(Register register) {
		Register register2 = registerRepository.save(register);
		if (register2 == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Register login(String email, String password) {
		return registerRepository.login(email, password);
	}
}
