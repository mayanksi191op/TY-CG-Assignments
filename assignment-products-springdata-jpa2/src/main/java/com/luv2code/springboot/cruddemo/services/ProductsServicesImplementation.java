package com.luv2code.springboot.cruddemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.ProductsRepository;
import com.luv2code.springboot.cruddemo.entity.Products;

@Service
public class ProductsServicesImplementation implements ProductsServices{
	
	@Autowired
	private ProductsRepository productsRepository;
	
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
	
}
