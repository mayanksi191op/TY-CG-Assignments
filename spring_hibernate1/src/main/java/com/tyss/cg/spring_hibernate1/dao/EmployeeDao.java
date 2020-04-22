package com.tyss.cg.spring_hibernate1.dao;

import java.util.List;

import com.tyss.cg.spring_hibernate1.bean.EmployeeTable;

public interface EmployeeDao {
	
	List<EmployeeTable> get();
	
	//List<EmployeeTable> search();

	boolean save(EmployeeTable e);

	EmployeeTable get(int employee_id);

	boolean update(EmployeeTable e);
	
	boolean delete(int employee_id);
}
