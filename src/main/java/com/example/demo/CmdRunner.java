package com.example.demo;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

		}
	}
}
