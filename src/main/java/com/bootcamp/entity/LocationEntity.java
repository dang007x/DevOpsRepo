package com.bootcamp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class LocationEntity {
	@Id
	private Integer location_id;
	
	@Column
	private String street_address;
	
	@Column
	private String postal_code;
	
	@Column
	private String city;
	
	@Column
	private String state_province;
	
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryEntity country;
	
	public CountryEntity getCountry() {
		return country;
	}
	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	
	@OneToMany(mappedBy = "location")
	private List<DepartmentEntity> department = new ArrayList<>();
	
	public List<DepartmentEntity> getDepartment() {
		return department;
	}
	public void setDepartment(List<DepartmentEntity> department) {
		this.department = department;
	}
	
	
	public Integer getLocation_id() {
		return location_id;
	}

	public String getStreet_address() {
		return street_address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public String getCity() {
		return city;
	}

	public String getState_province() {
		return state_province;
	}

	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
}
