package com.example.demo.model.dtos;

public class CountryDto {

	private String name;
	private int totalCases;
	private int totalTests;
	private int activeCases;
	private String regionName;

	public int getTotalCases() {
		return totalCases;
	}

	public CountryDto setTotalCases(int totalCases) {
		this.totalCases = totalCases;
		return this;
	}

	public int getTotalTests() {
		return totalTests;
	}

	public CountryDto setTotalTests(int totalTests) {
		this.totalTests = totalTests;
		return this;
	}

	public int getActiveCases() {
		return activeCases;
	}

	public CountryDto setActiveCases(int activeCases) {
		this.activeCases = activeCases;
		return this;
	}

	public String getName() {
		return name;
	}

	public CountryDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}
