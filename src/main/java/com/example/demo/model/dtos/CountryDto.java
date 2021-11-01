package com.example.demo.model.dtos;

public class CountryDto {

	private String name;
	private int totalCases;
	private int totalTests;
	private int activeCases;
	private RegionDto regionDto;
	
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

	public RegionDto getRegionDto() {
		return regionDto;
	}

	public void setRegionDto(RegionDto regionDto) {
		this.regionDto = regionDto;
	}
	
	
}
