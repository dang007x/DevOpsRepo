package com.bootcamp.dto;

public class EmployeeInformationDTO {
	private Integer employee_id;
	private String name;
	private String department_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private Integer salary;
	private String job_id;
	private Integer manager_id;
	private Integer commission_pct;
	private String city;
	private String street_address;
	
	public Integer getEmployee_id() {
		return employee_id;
	}
	public String getName() {
		return name;
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
	public Integer getSalary() {
		return salary;
	}
	public String getJob_id() {
		return job_id;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public Integer getCommission_pct() {
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
	public void setName(String name) {
		this.name = name;
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
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public void setCommission_pct(Integer commission_pct) {
		this.commission_pct = commission_pct;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
}
