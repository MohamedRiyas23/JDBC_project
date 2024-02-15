package com.employee.dto;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String dept;
	private double sal;
	
	public Employee(int id, String firstName,String lastName, String dept, double sal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName=lastName;
		this.dept = dept;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
	
	
}
