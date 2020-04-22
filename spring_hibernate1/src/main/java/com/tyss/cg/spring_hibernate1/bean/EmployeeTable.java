package com.tyss.cg.spring_hibernate1.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table
@Component
public class EmployeeTable {
	
	@Id
	@Column
	private Integer employee_id;
	@Column
	private String name;
	@Column
	private String dob;
	@Column
	private String joining_date;
	@Column
	private Integer dept_id;
	@Column
	private String designation;
	@Column
	private String salary;
	@Column
	private Integer manager_id;
	@Column
	private String email;
	@Column
	private String mobile;
	@Column
	private String password;
	@Override
	
	
	public String toString() {
		return "EmployeeTable [employee_id=" + employee_id + ", name=" + name + ", dob=" + dob + ", joining_date="
				+ joining_date + ", dept_id=" + dept_id + ", designation=" + designation + ", salary=" + salary
				+ ", manager_id=" + manager_id + ", email=" + email + ", mobile=" + mobile + ", password=" + password
				+ "]";
	}
}
