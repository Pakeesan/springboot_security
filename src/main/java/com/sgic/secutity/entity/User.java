package com.sgic.secutity.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class User {
	
	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	private  String email;
	
	@NotEmpty
	private  String name;
	
	
	@Size(min=4)
	private  String password;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Task> task;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="User_ROLES",joinColumns= {
			@JoinColumn(name="USER_EMAIL",referencedColumnName="email")}
	,inverseJoinColumns= {@JoinColumn(name="ROLE_NAME",referencedColumnName="name")})
	private List<Role> roles;
	
	
	
	public User(String email, String name, String password) {
		
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public User() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
