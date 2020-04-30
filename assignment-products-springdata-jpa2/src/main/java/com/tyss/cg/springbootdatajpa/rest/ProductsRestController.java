package com.tyss.cg.springbootdatajpa.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.cg.springbootdatajpa.entity.Products;
import com.tyss.cg.springbootdatajpa.entity.Register;
import com.tyss.cg.springbootdatajpa.exception.UserNotFoundException;
import com.tyss.cg.springbootdatajpa.response.Response;
import com.tyss.cg.springbootdatajpa.services.ProductsServices;

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
	public Response<Products> getById(@PathVariable int productId) {
		Products products = productsServices.getById(productId);
		
		if (products == null) {
			throw new UserNotFoundException("id not found " + productId);
		}else {
			return new Response<Products>(false, "product found", products);
		}
		
	}
	
	@DeleteMapping("/products/{productId}")
	public Response<Products> delete(@PathVariable int productId) {
		Products products = productsServices.getById(productId);
		
		if (products == null) {
			throw new UserNotFoundException("id not found " + productId);
		} else {
			productsServices.deleteProducts(productId);
			return new Response<Products>(false, "Product deleted", products);
		}
	}
	
	@PutMapping("/products")
	public Response<Products> update(@RequestBody Products products) {
		Products products2 = productsServices.getById(products.getId());
		if (products2 == null) {
			return new Response<Products>(true, "product not found", null);
		}
		if (productsServices.saveProduct(products) == false) {
			throw new RuntimeException("please enter the data correctly");
		}else {
			return new Response<Products>(false, "product updated", products);
		}

	}
	
	@PostMapping("/products")
	public Response<Products> save(@RequestBody Products products) {
		
		products.setId(0);
		
		if (productsServices.saveProduct(products) == false) {
			throw new RuntimeException("please enter data correctly");
		}else {
			return new Response<Products>(false, "product entered", products);
		}
	}
	
	
	//Register
	
	@GetMapping("/register")
	public List<Register> findAllUsers() {
		return productsServices.findAllUsers();
	}
	
	@GetMapping("/register/{email}")
	public Response<Register> getByIdUser(@PathVariable String email) {
		Register register = productsServices.getByIdUser(email);
		
		if (register == null) {
			throw new UserNotFoundException("record not found " + email);
		}else {
			return new Response<Register>(false, "record found", register);
		}
	}
	
	@DeleteMapping("/register/{email}")
	public Response<Register> deleteUsers(@PathVariable String email) {
		Register register = productsServices.getByIdUser(email);
		
		if (register == null) {
			throw new UserNotFoundException("record not found");
		} else {
			productsServices.deleteUser(email);
			return new Response<Register>(false, "record deleted", register);
		}
	}
	
	@PutMapping("/register")
	public Response<Register> updateUsers(@RequestBody Register register) {
		if (productsServices.saveUser(register) == false) {
			throw new RuntimeException("please enter the data correctly");
		}else {
			return new Response<Register>(false, "User updated", register);
		}
	}
	
	@PostMapping("/register")
	public Response<Register> save(@RequestBody Register register) {
		
		if (productsServices.saveUser(register) == false) {
			throw new RuntimeException("please enter correctly");
		}else {
			return new Response<Register>(false, "user registered", register);
		}
		
	}
	
	@PostMapping("register/login")
	public Response<Register> login(@RequestBody Register register){
		 Register register2 = productsServices.login(register.getEmail(), register.getPassword());
		 
		 if (register2 != null) {
			return new Response<Register>(false, "login successfull", register2);
		}else {
			return new Response<Register>(true, "email is not registered", null);
		}
	}
	
}
