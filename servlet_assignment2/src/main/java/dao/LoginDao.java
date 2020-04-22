package dao;

import Bean.EmployeeTable;

public interface LoginDao {

	public String loginCheck(Integer employee_id, String password);
}
