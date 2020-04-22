package com.tyss.cg.spring_hibernate1.dao;

import com.tyss.cg.spring_hibernate1.bean.EmployeeTable;

public interface LoginDao {
	
	public String loginCheck(EmployeeTable employeeTable);
	public String nameRetrieve(Integer employee_id, String password);
}
