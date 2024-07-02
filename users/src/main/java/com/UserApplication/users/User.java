package com.UserApplication.users;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users", schema="usersdb")
@NamedQueries({
	@NamedQuery(name="getGroupsByUserId", query="SELECT grps.group FROM UserGroups grps WHERE grps.user.username = :userID")
})
public class User {
	
	protected User() {
		
	}

	@Id
	@Column(name="user_id")
	private String username;
	@Column(name="firstname")
	private String firstName;
	@Column(name="surname")
	private String surname;
	@Column(name="email")
	private String email;
	@Column(name="dateofbirth")
	private String dOB;
	@Column(name="password")
	private String password;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<UserGroups> userGroups;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String firstName, String surname, String doB) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.surname = surname;
		this.dOB = doB;
	}
	public String getUsername() {
		return username;
	}
	public void setId(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return surname;
	}
	public void setLastName(String lastName) {
		this.surname = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getdOB() {
		return dOB;
	}
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
	public List<UserGroups> getGroups() {
		return userGroups;
	}
	public void setGroups(List<UserGroups> groups) {
		this.userGroups = groups;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", surname=" + surname + ", email=" + email
				+ ", dOB=" + dOB + ", password=" + password + ", userGroups=" + userGroups + "]";
	}
	
	
}
