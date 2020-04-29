package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "register")
public class Register {
	
	@Id
	@Column
	private String email;
	@Column
	private String fullname;
	@Column
	private String password;
	@Column
	private String role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", fullname=" + fullname + ", password=" + password + ", role=" + role
				+ "]";
	}
	public Register(String email, String fullname, String password, String role) {
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.role = role;
	}
	
	
	public Register() {
		
	}
}
