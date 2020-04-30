package com.tyss.cg.springbootdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.cg.springbootdatajpa.entity.Register;

public interface RegisterRepository extends JpaRepository<Register, String> {

	@Query("from Register where email=?1 and password=?2")
	Register login(String email, String password);
}
