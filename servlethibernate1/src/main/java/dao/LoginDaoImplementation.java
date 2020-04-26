package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.EmployeeTable;

public class LoginDaoImplementation implements LoginDao {

	@Override
	public String loginCheck(Integer employee_id, String password) {

		String query = "select a from EmployeeTable a where a.employee_id = :employee_id and a.password = :password";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query2 = entityManager.createQuery(query);
		query2.setParameter("employee_id", employee_id);
		query2.setParameter("password", password);
		entityTransaction.begin();
		entityTransaction.commit();
		List<EmployeeTable> list = query2.getResultList();
		if (list.isEmpty()) {
			System.out.println("false");
			return "false";
		} else {
			System.out.println("true");
			return "true";
		}
	}

	@Override
	public String nameRetrieve(Integer employee_id, String password) {

		String query = "select a from EmployeeTable a where a.employee_id = :employee_id and a.password = :password";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query2 = entityManager.createQuery(query);
		query2.setParameter("employee_id", employee_id);
		query2.setParameter("password", password);
		entityTransaction.begin();
		entityTransaction.commit();
		List<EmployeeTable> list = query2.getResultList();
		return list.get(0).getName();
	}
}
