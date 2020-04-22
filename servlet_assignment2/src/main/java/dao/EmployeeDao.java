package dao;

import java.util.List;

import Bean.EmployeeTable;

public interface EmployeeDao {
	List<EmployeeTable> get();

	boolean save(EmployeeTable e);

	EmployeeTable get(int employee_id);

	boolean update(EmployeeTable e);
	
	boolean delete(int employee_id);
}
