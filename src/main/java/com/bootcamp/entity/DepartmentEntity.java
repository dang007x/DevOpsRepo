package com.bootcamp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer department_id;
	
	@Column
	private String department_name;
	
	
	@OneToMany(mappedBy = "department")
	private List<EmployeeEntity> employee = new ArrayList<>();
	
	public List<EmployeeEntity> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeeEntity> employee) {
		this.employee = employee;
	}
	
	
	@OneToOne
	@JoinColumn(name = "manager_id")
	private EmployeeEntity manager;
	
	public EmployeeEntity getManager() {
		return manager;
	}
	public void setManager(EmployeeEntity manager) {
		this.manager = manager;
	}
	
	
	@OneToMany(mappedBy = "departmentHistory")
	private List<JobHistoryEntity> historyJob = new ArrayList<>();
	
	public List<JobHistoryEntity> getHistoryJob() {
		return historyJob;
	}
	public void setHistoryJob(List<JobHistoryEntity> historyJob) {
		this.historyJob = historyJob;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private LocationEntity location;
	
	public LocationEntity getLocation() {
		return location;
	}
	public void setLocation(LocationEntity location) {
		this.location = location;
	}
	
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
}
