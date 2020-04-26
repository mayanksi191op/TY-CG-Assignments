package dao;

public interface LoginDao {
	
	public String loginCheck(Integer employee_id, String password);
	public String nameRetrieve(Integer employee_id, String password);
	
}
