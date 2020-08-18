package com.bootcamp.dto;

public class EmployeeFoundDTO {
	private Integer employee_id;
	private String name;
	private String email;
	private Integer department_id;
	private String department_name;
	private Integer salary;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
