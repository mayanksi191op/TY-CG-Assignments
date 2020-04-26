package dao;

import java.util.List;

import bean.EmployeeTable;



public interface EmployeeDao {
	List<EmployeeTable> get();
	
	//List<EmployeeTable> search();

	boolean save(EmployeeTable e);

	EmployeeTable get(int employee_id);

	boolean update(EmployeeTable e);
	
	boolean delete(int employee_id);
}
