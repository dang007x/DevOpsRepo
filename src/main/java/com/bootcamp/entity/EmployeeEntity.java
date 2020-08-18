package com.bootcamp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
	
	@Id
	@Column
	private Integer employee_id;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String phone_number;
	
	@Column
	private String hire_date;
	
	@Column
	private Integer salary;
	
	@Column
	private Integer commission_pct;
	

	@OneToOne(mappedBy = "manager")
	private DepartmentEntity manager;
	
	public DepartmentEntity getManager() {
		return manager;
	}
	public void setManager(DepartmentEntity manager) {
		this.manager = manager;
	}

	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentEntity department;
	
	public DepartmentEntity getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private JobEntity job;

	public JobEntity getJob() {
		return job;
	}
	public void setJob(JobEntity job) {
		this.job = job;
	}
	
	
	@OneToMany(mappedBy = "employeeHistory")
	private List<JobHistoryEntity> historyJob = new ArrayList<>();
	
	public List<JobHistoryEntity> getHistoryJob() {
		return historyJob;
	}
	public void setHistoryJob(List<JobHistoryEntity> historyJob) {
		this.historyJob = historyJob;
	}
	
	
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

	public Integer getSalary() {
		return salary;
	}
	public Integer getCommission_pct() {
		return commission_pct;
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

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setCommission_pct(Integer commission_pct) {
		this.commission_pct = commission_pct;
	}
}
