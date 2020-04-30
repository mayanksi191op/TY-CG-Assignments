package com.tyss.cg.springbootdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.cg.springbootdatajpa.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
