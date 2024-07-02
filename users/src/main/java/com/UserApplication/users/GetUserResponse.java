package com.UserApplication.users;

import java.util.List;

public class GetUserResponse {
	
	private String username;
	private String firstName;
	private String surname;
	private String email;
	private String dOB;
	private String password;
	private List<Groups> userGroups;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getdOB() {
		return dOB;
	}
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Groups> getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(List<Groups> userGroups) {
		this.userGroups = userGroups;
	}

}
