package com.example.demo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "total_cases")
	private int totalCases;

	@Column(name = "total_tests")
	private int totalTests;

	@Column(name = "active_cases")
	private int activeCases;

	@Column
	private String region;
	
	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public int getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(int totalTests) {
		this.totalTests = totalTests;
	}

	public int getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegionName() {
		return region;
	}

	public void setRegionName(String regionName) {
		this.region = regionName;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", totalCases=" + totalCases + ", totalTests=" + totalTests + ", activeCases="
				+ activeCases + ", region=" + region + "]";
	}


	
}
