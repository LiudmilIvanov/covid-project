package com.example.demo.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.dtos.CountryDto;
import com.opencsv.CSVWriter;

@Component
public class ExportToCsvImpl implements ExportToCsv{

	@Override
	public void exportToFIle(List<CountryDto> dtos) throws IOException {

		
		SimpleDateFormat formatter = new SimpleDateFormat("yy_MM_dd");  
	    Date date = new Date();  
		
		String[] header = { "REGION", "COUNTRY", "TOTALCASES", "TOTALTESTS", "ACTIVECASES" };
		

		String fileName = "export_Asia_" + formatter.format(date).toString() + ".csv";
		CSVWriter writer = new CSVWriter(new FileWriter("c:\\Games\\" + fileName));
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
