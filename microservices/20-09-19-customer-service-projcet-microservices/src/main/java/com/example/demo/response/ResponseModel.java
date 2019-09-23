package com.example.demo.response;

public class ResponseModel {

	private String userId;
	private String firstname;
	private String lastName;
	private String email;

	public ResponseModel() {
		super();
	}
	public ResponseModel(String userId, String firstname, String lastName, String email) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
