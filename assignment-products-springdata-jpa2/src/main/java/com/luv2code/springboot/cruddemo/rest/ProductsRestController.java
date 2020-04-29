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

import com.luv2code.springboot.cruddemo.entity.Products;
import com.luv2code.springboot.cruddemo.entity.Register;
import com.luv2code.springboot.cruddemo.services.ProductsServices;

@RestController
@RequestMapping("/api")
public class ProductsRestController {
	
	@Autowired
	private ProductsServices productsServices;
	
	
	//Products
	
	@GetMapping("/products")
	public List<Products> findAll() {
		return productsServices.findAll();
	}
	
	@GetMapping("/products/{productId}")
	public Products getById(@PathVariable int productId) {
		Products products = productsServices.getById(productId);
		
		if (products == null) {
			throw new RuntimeException("id not found " + productId);
		}
		return products;
	}
	
	@DeleteMapping("/products/{productId}")
	public String delete(@PathVariable int productId) {
		Products products = getById(productId);
		
		if (products == null) {
			throw new RuntimeException("id not found " + productId);
		}

		productsServices.deleteProducts(productId);
		return "deleted";
	}
	
	@PutMapping("/products")
	public String update(@RequestBody Products products) {
		productsServices.saveProduct(products);
		return "updated";
	}
	
	@PostMapping("/products")
	public Products save(@RequestBody Products products) {
		
		products.setId(0);
		productsServices.saveProduct(products);
		return products;
	}
	
	
	//Register
	
	@GetMapping("/register")
	public List<Register> findAllUsers() {
		return productsServices.findAllUsers();
	}
	
	@GetMapping("/register/{email}")
	public Register getByIdUser(@PathVariable String email) {
		Register register = productsServices.getByIdUser(email);
		
		if (register == null) {
			throw new RuntimeException("email not found " + email);
		}
		return register;
	}
	
	@DeleteMapping("/register/{email}")
	public String deleteUsers(@PathVariable String email) {
		Register register = productsServices.getByIdUser(email);
		
		if (register == null) {
			throw new RuntimeException("email not found " + email);
		}

		productsServices.deleteUser(email);
		return "deleted";
	}
	
	@PutMapping("/register")
	public String updateUsers(@RequestBody Register register) {
		productsServices.saveUser(register);
		return "updated";
	}
	
	@PostMapping("/register")
	public Register save(@RequestBody Register register) {
		
		productsServices.saveUser(register);
		return register;
	}
	

}
