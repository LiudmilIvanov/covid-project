package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Formatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.CountryService;
import com.example.demo.utils.TableUtil;

@Component
public class CmdRunner implements CommandLineRunner {

	private final CountryService countryService;
	private final BufferedReader bufferedReader;
	private final TableUtil tableUtil;

	@Autowired
	public CmdRunner(CountryService countryService, BufferedReader bufferedReader, TableUtil tableUtil) {
		this.countryService = countryService;
		this.bufferedReader = bufferedReader;
		this.tableUtil = tableUtil;
	}

	@Override
	public void run(String... args) throws Exception {
		countryService.getCountryDetails();

		while (true) {
			String input = bufferedReader.readLine();

			tableUtil.printTable(countryService.getCountriesByRegion(input));

//			System.out.println("-----------------------------------------------------------------------------");
//			System.out.printf("%10s %30s %15s %15s %15s %n", "REGION", "COUNTRY", "TOTALCASES", "TOTALTESTS" ,"ACTIVECASES");
//			System.out.println("-----------------------------------------------------------------------------");
//			
//			countryService.getCountriesByRegion(input).stream().forEach(country -> {
//				
//				System.out.printf("%10s %25s %15d %15d %15d %n", country.getRegionName(), country.getName(), 
//						country.getTotalCases(), country.getTotalTests() ,country.getActiveCases());
//				
//			});
//		}

		}
	}
}
