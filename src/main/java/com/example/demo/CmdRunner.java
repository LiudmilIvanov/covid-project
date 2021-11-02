package com.example.demo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.dtos.CountryDto;
import com.example.demo.model.entities.Country;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.CountryService;
import com.example.demo.utils.ExportToCsv;
import com.example.demo.utils.TableUtil;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Component
public class CmdRunner implements CommandLineRunner {

	private final CountryService countryService;
	private final BufferedReader bufferedReader;
	private final TableUtil tableUtil;
	private final ExportToCsv exportToCsv;

	@Autowired
	public CmdRunner(CountryService countryService, BufferedReader bufferedReader, TableUtil tableUtil,
			ExportToCsv exportToCsv) {
		this.countryService = countryService;
		this.bufferedReader = bufferedReader;
		this.tableUtil = tableUtil;
		this.exportToCsv = exportToCsv;
	}

	@Override
	public void run(String... args) throws Exception {
		countryService.getCountryDetails();

		while (true) {
//			 String input = bufferedReader.readLine();

			// tableUtil.printTable(countryService.getCountriesByRegion(input));

//			Writer writer = new FileWriter("c:\\Games\\test.csv");
//			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
////			beanToCsv.write(countryRepository.findAll());
//		
//			beanToCsv.write(countryService.getCountriesByRegion("Asia"));
//			System.out.println();
//			writer.close();
			List<CountryDto> dtos = countryService.getCountriesByRegion("Asia");

			exportToCsv.exportToFIle(dtos);
//			String[] header = { "REGION", "COUNTRY", "TOTALCASES", "TOTALTESTS", "ACTIVECASES" };
//
//			CSVWriter writer = new CSVWriter(new FileWriter("c:\\Games\\test.csv"));
//			writer.writeNext(header);
//
//			dtos.stream().forEach(country -> {
//				String[] details = { country.getRegionName(), country.getName(),
//						String.valueOf(country.getTotalCases()), String.valueOf(country.getTotalTests()),
//						String.valueOf(country.getActiveCases()) };
//				
//				writer.writeNext(details);
//			});
//
//			writer.close();

		}
	}
}
