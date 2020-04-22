package dao;

import java.util.List;

import bean.UserBean;


public interface UserDao {
	List<UserBean> get();

	boolean save(UserBean e);

	UserBean get(int id);

	boolean update(UserBean e);
	
	boolean delete(int id);

}