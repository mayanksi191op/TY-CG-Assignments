package com.tyss.cg.spring_hibernate1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.cg.spring_hibernate1.bean.EmployeeTable;

@Repository
public class LoginDaoImplementation implements LoginDao{
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public String loginCheck(EmployeeTable employeeTable) {
		
		System.out.println(employeeTable.getEmployee_id());
		System.out.println(employeeTable.getPassword());
		String query = "select a from EmployeeTable a where a.employee_id = :employee_id and a.password = :password";
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query2 = entityManager.createQuery(query);
		query2.setParameter("employee_id", employeeTable.getEmployee_id());
		query2.setParameter("password", employeeTable.getPassword());
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
