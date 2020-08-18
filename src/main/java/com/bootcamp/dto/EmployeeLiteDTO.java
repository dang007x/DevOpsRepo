package com.bootcamp.dto;

public class EmployeeLiteDTO {
	private Integer employee_id;
	private Integer department_id;
	private String name;
	private String email;
	
	
	public Integer getEmployee_id() {
		return employee_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
