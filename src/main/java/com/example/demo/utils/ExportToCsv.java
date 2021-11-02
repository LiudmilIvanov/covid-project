package com.example.demo.utils;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.dtos.CountryDto;

public interface ExportToCsv {

	public void exportToFIle(List<CountryDto> dtos, String input) throws IOException;
	
	public void writeInCsv(List<CountryDto> dtos, String input) throws IOException;
	
	public String getCurrentDate();
}
