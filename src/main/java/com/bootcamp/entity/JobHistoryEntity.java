package com.bootcamp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "job_history")
public class JobHistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Date start_date;
	
	@Column
	private Date end_date;

	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employeeHistory;
	
	public EmployeeEntity getEmployeeHistory() {
		return employeeHistory;
	}
	public void setEmployeeHistory(EmployeeEntity employeeHistory) {
		this.employeeHistory = employeeHistory;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "deparment_id")
	private DepartmentEntity departmentHistory;
	
	public DepartmentEntity getDepartmentHistory() {
		return departmentHistory;
	}
	public void setDepartmentHistory(DepartmentEntity departmentHistory) {
		this.departmentHistory = departmentHistory;
	}
	
	
	@OneToOne
	@JoinColumn(name = "job_id")
	private JobEntity jobId;
	
	public JobEntity getJobId() {
		return jobId;
	}
	public void setJobId(JobEntity jobId) {
		this.jobId = jobId;
	}
	
	
	public Date getStart_date() {
		return start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
}
