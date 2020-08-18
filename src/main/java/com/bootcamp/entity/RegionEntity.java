package com.bootcamp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class RegionEntity {
	@Id
	private Integer region_id;
	
	@Column
	private String reigon_name;

	
	@OneToMany(mappedBy = "region")
	private List<CountryEntity> country = new ArrayList<>();

	public List<CountryEntity> getCountry() {
		return country;
	}
	public void setCountry(List<CountryEntity> country) {
		this.country = country;
	}

	
	public Integer getRegion_id() {
		return region_id;
	}

	public String getReigon_name() {
		return reigon_name;
	}

	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public void setReigon_name(String reigon_name) {
		this.reigon_name = reigon_name;
	}
}
