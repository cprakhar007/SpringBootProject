package com.nagarro.library.entity;

import javax.persistence.Id;

public class User {
	
	@Id
	private String username;
	private String userpassword;
	
	public User() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	

}
