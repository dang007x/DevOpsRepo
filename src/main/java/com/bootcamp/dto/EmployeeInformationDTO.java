package com.bootcamp.dto;

public class EmployeeInformationDTO {
	private Integer employee_id;
	private String full_name;
	private String first_name;
	private String last_name;
	private String department_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private Double salary;
	private String job_id;
	private Integer manager_id;
	private Double commission_pct;
	private String city;
	private String street_address;
	
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public String getDepartment_name() {
		return department_name;
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
	public Double getSalary() {
		return salary;
	}
	public String getJob_id() {
		return job_id;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public Double getCommission_pct() {
		return commission_pct;
	}
	public String getCity() {
		return city;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public void setFirst_ame(String first_name) {
		this.first_name = first_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
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
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public void setCommission_pct(Double commission_pct) {
		this.commission_pct = commission_pct;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
}
