package com;

public class BookingDetails {

	private String fullName;
	private int age;
	private String email;
	private String address;
	private String date;
	private Flight bookedflight;
	private int no_of_ppl=0;
	
	public BookingDetails(String fullName, int age, String email, String address) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.address = address;
	}	
	
	public BookingDetails(String date, Flight bookedflight) {
		super();
		this.date = date;
		this.bookedflight = bookedflight;
	}
	

	public BookingDetails(int no,String fullName, int age, String email, String address, String date, Flight bookedflight) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.address = address;
		this.date = date;
		this.bookedflight = bookedflight;
		this.no_of_ppl=no;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Flight getBookedflight() {
		return bookedflight;
	}

	public void setBookedflight(Flight bookedflight) {
		this.bookedflight = bookedflight;
	}

	public int getNo_of_ppl() {
		return no_of_ppl;
	}

	public void setNo_of_ppl(int no_of_ppl) {
		this.no_of_ppl = no_of_ppl;
	}
	
	
}
