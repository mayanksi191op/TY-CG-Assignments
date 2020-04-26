package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bean.EmployeeTable;


public class InsertEmployeeTable {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction =entityManager.getTransaction();
		
		EmployeeTable employeeTable1 = new EmployeeTable();
		employeeTable1.setDept_id(12);
		employeeTable1.setDesignation("developer");
		employeeTable1.setDob("10-05-1996");
		employeeTable1.setEmail("mayanksi191op@gmail.com");
		employeeTable1.setEmployee_id(1);
		employeeTable1.setJoining_date("15-12-1996");
		employeeTable1.setManager_id(10);
		employeeTable1.setMobile("7681093264");
		employeeTable1.setName("Mayank");
		employeeTable1.setSalary("3.2");
		employeeTable1.setPassword("Qwerty@123");
		
		entityTransaction.begin();
		entityManager.persist(employeeTable1);
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
