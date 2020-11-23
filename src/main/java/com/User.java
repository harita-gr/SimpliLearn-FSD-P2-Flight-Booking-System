package com;

public class User {
	
	private String fname="";
	private String lname="";
	private String email="";
	private String phoneno="";
	private String password="";
	private int age=0;
	private String address="";
	private String fullname="";
	
	// Constructors
	
	public User(String fname, String lname, String email, String phoneno, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public User(String email2, int age2, String address2, String fullName2) {
		super();
		this.email = email2;
		this.age = age2;
		this.address = address2;
		this.fullname = fullName2;
	}

	// Getters & Setters
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
			
	
	
	
	
	
	
}