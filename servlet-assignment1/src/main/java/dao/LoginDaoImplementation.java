package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.UserBean;
import util.DBConnectionUtil;

public class LoginDaoImplementation implements LoginDao {
	
	@Override
	public String loginCheck(UserBean userBean) {
		String query = "select * from usertable where email =? and password =?";
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userBean.getEmail());
			preparedStatement.setString(2, userBean.getPassword());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				return "true";
			} else {
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return "error";
	
	}
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		Query query2 = entityManager.createQuery(query);
//		List<UserBean> list = query2.getResultList();
//		
//		entityManager.close();
//		entityManagerFactory.close();
//		if (list.isEmpty()) {
//			return "false";
//		} else {
//			return "true";
//		}
//	}
}
