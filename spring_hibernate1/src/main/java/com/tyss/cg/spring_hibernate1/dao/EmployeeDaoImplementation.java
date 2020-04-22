package com.tyss.cg.spring_hibernate1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.cg.spring_hibernate1.bean.EmployeeTable;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao{
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public List<EmployeeTable> get() {
		List<EmployeeTable> list = new ArrayList<EmployeeTable>();
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sqlString = "select a from EmployeeTable a";
		TypedQuery<EmployeeTable> typedQuery = entityManager.createQuery(sqlString, EmployeeTable.class);
		list = typedQuery.getResultList();
//		for (EmployeeTable employeeTable : list) {
//			System.out.println(employeeTable.toString());
//		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}

	@Override
	public boolean save(EmployeeTable e) {
		Boolean flag = false;
	//	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String sqlString = "insert into EmployeeTable(employee_id, name, dob, joining_date, dept_id, designation, salary, manager_id, email, mobile, password) values ('"
				+ e.getEmployee_id() + "', '" + e.getName() + "', '" + e.getDob() + "', '" + e.getJoining_date()
				+ "', '" + e.getDept_id() + "', '" + e.getDesignation() + "', '" + e.getSalary() + "', '"
				+ e.getManager_id() + "', '" + e.getEmail() + "', '" + e.getMobile() + "', '" + e.getPassword() + "')";
		entityTransaction.begin();
		TypedQuery<EmployeeTable> query = (TypedQuery<EmployeeTable>) entityManager.createNativeQuery(sqlString);
		query.executeUpdate();
		entityTransaction.commit();
		flag = true;
		return flag;
	}

	@Override
	public EmployeeTable get(int employee_id) {
		System.out.println("inside get(int)");
		EmployeeTable employeeTable = new EmployeeTable();
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sqlString = "select a from EmployeeTable a where a.employee_id =" + employee_id;
		Query query = entityManager.createQuery(sqlString, EmployeeTable.class);
		// query.setParameter("employee_id", employee_id);
		List<EmployeeTable> list = query.getResultList();

		employeeTable.setDept_id(list.get(0).getDept_id());
		employeeTable.setDesignation(list.get(0).getDesignation());
		employeeTable.setDob(list.get(0).getDob());
		employeeTable.setEmail(list.get(0).getEmail());
		employeeTable.setEmployee_id(list.get(0).getEmployee_id());
		employeeTable.setJoining_date(list.get(0).getJoining_date());
		employeeTable.setManager_id(list.get(0).getManager_id());
		employeeTable.setMobile(list.get(0).getMobile());
		employeeTable.setName(list.get(0).getName());
		employeeTable.setPassword(list.get(0).getPassword());
		employeeTable.setSalary(list.get(0).getSalary());

		return employeeTable;
	}

	@Override
	public boolean update(EmployeeTable e) {
		Boolean flag = false;
	//	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		String sqlString = "update EmployeeTable set name = '" + e.getName() + "', dob = '" + e.getDob()
				+ "', joining_date = '" + e.getJoining_date() + "', dept_id = '" + e.getDept_id() + "', designation = '"
				+ e.getDesignation() + "', salary = '" + e.getSalary() + "', manager_id = '" + e.getManager_id()
				+ "', email = '" + e.getEmail() + "', mobile = '" + e.getMobile() + "', password = '" + e.getPassword()
				+ "' where employee_id = '"+ e.getEmployee_id() +"'";
		Query query = entityManager.createQuery(sqlString);
		query.executeUpdate();
		entityTransaction.commit();

		flag = true;
		return flag;
	}

	@Override
	public boolean delete(int employee_id) {
		Boolean flag = false;
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String sqlString = "delete from EmployeeTable where employee_id = :employee_id";
		entityTransaction.begin();
		TypedQuery<EmployeeTable> query = (TypedQuery<EmployeeTable>) entityManager.createQuery(sqlString);
		query.setParameter("employee_id", employee_id);
		query.executeUpdate();
		System.out.println("deleted");
		flag = true;
		entityTransaction.commit();
		return flag;
	}

//	public static void main(String[] args) {
//		EmployeeDaoImplementation daoImplementation = new EmployeeDaoImplementation();
//		daoImplementation.get();
//		daoImplementation.delete(1);
//		daoImplementation.get(1);
//		
//	}
}
