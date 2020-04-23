package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
