package com.example.demo.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.dtos.CountryDto;

@Component
public class TableUtilImpl implements TableUtil {

	@Override
	public void printTable(List<CountryDto> dtos) {

		System.out.println("---------------------------------------------------------------------------------------");
		System.out.printf("%10s %30s %15s %15s %15s %n", "REGION", "COUNTRY", "TOTALCASES", "TOTALTESTS",
				"ACTIVECASES");
		System.out.println("---------------------------------------------------------------------------------------");

		dtos.stream().forEach(country -> {

			System.out.printf("%10s %25s %15d %15d %15d %n", country.getRegionName(), country.getName(),
					country.getTotalCases(), country.getTotalTests(), country.getActiveCases());
		});
	}
}
