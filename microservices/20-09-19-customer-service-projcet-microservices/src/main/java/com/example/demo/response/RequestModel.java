package com.example.demo.response;

public class RequestModel {

	
	private String firstname;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String matchingPassword;
	private String address;
    private String city;
	private String state;
	private int postalCode;
	private String country;
	
	
	
	public RequestModel(String firstname, String lastName, String email, String password, String phoneNumber,
			String matchingPassword, String address, String city, String state, int postalCode, String country) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.matchingPassword = matchingPassword;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}


	public String getMatchingPassword() {
		return matchingPassword;
	}


	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public RequestModel() {
		super();
	}

	
	
	
}
