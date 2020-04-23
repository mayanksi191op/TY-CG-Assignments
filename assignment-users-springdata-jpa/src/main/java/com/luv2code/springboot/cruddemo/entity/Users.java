package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int age;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String sex;
	@Override
	
	public String toString() {
		return "Users [id=" + id + ", age=" + age + ", username=" + username + ", email=" + email + ", password="
				+ password + ", sex=" + sex + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Users(int id, int age, String username, String email, String password, String sex) {
		this.id = id;
		this.age = age;
		this.username = username;
		this.email = email;
		this.password = password;
		this.sex = sex;
	}

	public Users() {
		
	}

}
