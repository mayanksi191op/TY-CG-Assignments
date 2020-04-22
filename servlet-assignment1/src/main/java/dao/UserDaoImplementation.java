package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.UserBean;
import util.DBConnectionUtil;

public class UserDaoImplementation implements UserDao{
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<UserBean> get() {

		List<UserBean> list = new ArrayList<UserBean>();

		try {
			String sql = "select * from usertable";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				UserBean userBean = new UserBean();
				// same as, UserBean UserBean = new UserBean();
				userBean.setId(resultSet.getInt("id"));
				userBean.setName(resultSet.getString("name"));
				userBean.setSex(resultSet.getString("sex"));
				userBean.setCountry(resultSet.getString("country"));
				userBean.setEmail(resultSet.getString("email"));
				userBean.setPassword(resultSet.getString("password"));
				
				// add employee to list
				list.add(userBean);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String sqlString = "select a from usertable a";
//		Query query = entityManager.createQuery(sqlString, UserBean.class);
//		list = query.getResultList();
//		System.out.println(list);
//		entityManager.close();
//		entityManagerFactory.close();
//		return list;
		
	}
	
	@Override
	public boolean save(UserBean e) {
		boolean flag = false;

		try {
			String sqlString = "INSERT INTO usertable(name, password, email, country, sex) VALUES('"+e.getName()+"', '"+e.getPassword()+"', '"+e.getEmail()+"', '"+e.getCountry()+"', '"+e.getSex()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return flag;
		
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String sqlString = "INSERT INTO usertable(name, password, email, country, sex) VALUES('"+e.getName()+"', '"+e.getPassword()+"', '"+e.getEmail()+"', '"+e.getCountry()+"', '"+e.getSex()+"')";
//		Query query = entityManager.createQuery(sqlString, UserBean.class);
//		query.executeUpdate();
//		flag = true;
//		entityManager.close();
//		entityManagerFactory.close();
//		return flag;
	}
	
	@Override
	public UserBean get(int id) {
		UserBean userBean =null;
		try {
			userBean = new UserBean();
			String str = "select * from usertable where id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(str);
			while (resultSet.next()) {
				userBean.setId(resultSet.getInt("id"));
				userBean.setCountry(resultSet.getString("country"));
				userBean.setEmail(resultSet.getString("email"));
				userBean.setName(resultSet.getString("name"));
				userBean.setPassword(resultSet.getString("password"));
				userBean.setSex(resultSet.getString("sex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
		
		
//		userBean = new UserBean();
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String sqlString = "select * from usertable where id="+id;
//		Query query = entityManager.createQuery(sqlString, UserBean.class);
//		List<UserBean> list = query.getResultList();
//		userBean.setId();
		
	}

	@Override
	public boolean update(UserBean e) {
		boolean flag = false;
		try {
			String sqlString = "update usertable set name ='"+e.getName()+"', country = '"+e.getCountry()+"', email = '" +e.getEmail()+"', password = '" +e.getPassword()+"', sex = '" +e.getSex()+"' where id ="+e.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return flag;
		
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String sqlString = "update usertable set name ='"+e.getName()+"', country = '"+e.getCountry()+"', email = '" +e.getEmail()+"', password = '" +e.getPassword()+"', sex = '" +e.getSex()+"' where id ="+e.getId();
//		Query query = entityManager.createQuery(sqlString, UserBean.class);
//		query.executeUpdate();
//		flag = true;
//		entityManager.close();
//		entityManagerFactory.close();
//		return flag;
	}
	
	@Override
	public boolean delete(int id) {
		boolean flag =false;
		try {
			String str = "delete from usertable where id =" +id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(str);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String sqlString = "delete from usertable where id =" +id;
//		Query query = entityManager.createQuery(sqlString, UserBean.class);
//		query.executeUpdate();
//		flag = true;
//		entityManager.close();
//		entityManagerFactory.close();
//		return flag;
	}
	
//	public static void main(String[] args) {
//		UserDaoImplementation daoImplementation = new UserDaoImplementation();
//		daoImplementation.get();
//	}

}
