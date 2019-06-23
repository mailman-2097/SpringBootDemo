package com.boot.reactive.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class EmployeeModel {

	@JsonProperty
	public Integer getEmpId() {
		return empId;
	}
	
	public void setEmpId(Integer id) {
		this.empId = id;
	}

	@JsonProperty
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public EmployeeModel() {

	}
	public EmployeeModel(Integer empId, String firstName, String lastName, String email) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	private Integer empId;
	private String firstName;
	private String lastName;
	private String email;

	//getters and setters

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
}