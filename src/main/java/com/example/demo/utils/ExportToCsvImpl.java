package com.example.demo.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.constants.GlobalConstants;
import com.example.demo.model.dtos.CountryDto;
import com.opencsv.CSVWriter;

@Component
public class ExportToCsvImpl implements ExportToCsv {

	@Override
	public void exportToFIle(List<CountryDto> dtos, String input) throws IOException {

		if (input.trim().equals("") && input.isEmpty()) {
			return;
		}

		String fileName = "export_" + input + "_" + getCurrentDate() + ".csv";

		File file = new File(GlobalConstants.FILE_PATH + fileName);
		if (file.exists()) {
			return;
		}

		writeInCsv(dtos, fileName);

	}

	@Override
	public void writeInCsv(List<CountryDto> dtos, String fileName) throws IOException {
		String[] header = { "REGION", "COUNTRY", "TOTALCASES", "TOTALTESTS", "ACTIVECASES" };

		CSVWriter writer = new CSVWriter(new FileWriter(GlobalConstants.FILE_PATH + fileName));
		writer.writeNext(header);

		dtos.stream().forEach(country -> {
			String[] details = { country.getRegionName(), country.getName(), String.valueOf(country.getTotalCases()),
					String.valueOf(country.getTotalTests()), String.valueOf(country.getActiveCases()) };

			writer.writeNext(details);
		});

		writer.close();

	}

	@Override
	public String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yy_MM_dd");
		Date date = new Date();

		return formatter.format(date).toString();
	}

}
