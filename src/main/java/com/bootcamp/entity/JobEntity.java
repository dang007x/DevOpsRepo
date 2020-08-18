package com.bootcamp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class JobEntity {
	@Id
	private String job_id;
	
	@Column
	private String job_title;
	
	@Column
	private Integer max_salary;
	
	@Column
	private Integer min_salary;
	
	
	@OneToMany(mappedBy = "job")
	private List<EmployeeEntity> employee = new ArrayList<>();
	
	public List<EmployeeEntity> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeeEntity> employee) {
		this.employee = employee;
	}
	
	
	@OneToOne(mappedBy = "jobId")
	private JobHistoryEntity historyJob;

	public JobHistoryEntity getHistoryJob() {
		return historyJob;
	}
	public void setHistoryJob(JobHistoryEntity historyJob) {
		this.historyJob = historyJob;
	}
	
	
	public String getJob_id() {
		return job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public Integer getMax_salary() {
		return max_salary;
	}

	public Integer getMin_salary() {
		return min_salary;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public void setMax_salary(Integer max_salary) {
		this.max_salary = max_salary;
	}

	public void setMin_salary(Integer min_salary) {
		this.min_salary = min_salary;
	}
}
