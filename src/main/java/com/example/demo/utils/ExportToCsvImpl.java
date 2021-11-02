package com.example.demo.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.dtos.CountryDto;
import com.opencsv.CSVWriter;

@Component
public class ExportToCsvImpl implements ExportToCsv{

	@Override
	public void exportToFIle(List<CountryDto> dtos) throws IOException {

		String[] header = { "REGION", "COUNTRY", "TOTALCASES", "TOTALTESTS", "ACTIVECASES" };
		
		CSVWriter writer = new CSVWriter(new FileWriter("c:\\Games\\test.csv"));
		writer.writeNext(header);

		dtos.stream().forEach(country -> {
			String[] details = { country.getRegionName(), country.getName(),
					String.valueOf(country.getTotalCases()), String.valueOf(country.getTotalTests()),
					String.valueOf(country.getActiveCases()) };
			
			writer.writeNext(details);
		});

		writer.close();
		
	}

}
