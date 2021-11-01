package com.example.demo.services;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.dtos.CountryDto;

public interface CountryService {

	public void getCountryDetails() throws IOException;
	
	public List<CountryDto> getCountriesByRegion(String region);
	
}
