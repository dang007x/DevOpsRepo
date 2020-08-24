package com.bootcamp.dto;


public class EmployeeDTO {
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private Double salary;
	private Double commission_pct;
	private Integer department_id;
	
	
	public Integer getEmployee_id() {
		return employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public String getHire_date() {
		return hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public Double getSalary() {
		return salary;
	}
	public Double getCommission_pct() {
		return commission_pct;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public void setCommission_pct(Double commission_pct) {
		this.commission_pct = commission_pct;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
}

