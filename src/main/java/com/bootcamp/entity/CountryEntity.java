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
@Table(name = "countries")
public class CountryEntity {
	@Id
	private String country_id;
	
	@Column
	private String country_name;

	
	@ManyToOne
	@JoinColumn(name = "region_id")
	private RegionEntity region;

	public RegionEntity getRegion() {
		return region;
	}
	public void setRegion(RegionEntity region) {
		this.region = region;
	}
	
	
	@OneToMany(mappedBy = "country")
	private List<LocationEntity> location = new ArrayList<LocationEntity>();
	
	public List<LocationEntity> getLocation() {
		return location;
	}
	public void setLocation(List<LocationEntity> location) {
		this.location = location;
	}
	
	
	public String getCountry_id() {
		return country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
}
