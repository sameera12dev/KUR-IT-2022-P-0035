package com.xadmin.usermanagement.bean;

public class user {
	
	protected int id;
	protected String Full_name;
	protected String email;
	protected String password;
	protected int age;

	// Constructors
	public user() {}

	public user(String Full_name, String email, String password) {
		this.Full_name = Full_name;
		this.email = email;
		this.password = password;
		
	}

	public user(int id, String name, String email, String password) {
		this.id = id;
		this.Full_name = name;
		this.email = email;
		this.password = password;
	
	}

	// Getters and Setters
	
	public String getName() { return Full_name; }
	public void setName(String name) { this.Full_name = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	
}
