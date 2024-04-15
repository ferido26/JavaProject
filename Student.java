package com.sms;

public class Student {
	
	
	private int rollNumber;
	private String fullname;
	private int marks;
	private String email;
	private String department;
	private String gender;
	public int getRollNumber() {
		return rollNumber;
	}
	public String getFullname() {
		return fullname;
	}
	public int getMarks() {
		return marks;
	}
	public String getEmail() {
		return email;
	}
	public String getDepartment() {
		return department;
	}
	public String getGender() {
		return gender;
	}
	public Student(int rollNumber, String fullname, int marks, String email, String department, String gender) {
		super();
		this.rollNumber = rollNumber;
		this.fullname = fullname;
		this.marks = marks;
		this.email = email;
		this.department = department;
		this.gender = gender;
	}

}
