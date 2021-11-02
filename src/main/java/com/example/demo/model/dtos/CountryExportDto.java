package com.example.demo.model.dtos;

import com.opencsv.bean.CsvBindByName;

public class CountryExportDto {

	@CsvBindByName
	private String name;
	
	@CsvBindByName
	private int totalCases;
	
	@CsvBindByName
	private int totalTests;

	@CsvBindByName
	private int activeCases;
	
	@CsvBindByName
	private String regionName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}
