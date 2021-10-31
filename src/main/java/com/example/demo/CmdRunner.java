package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.services.CountryService;

@Component
public class CmdRunner implements CommandLineRunner {

	private CountryService countryService;

	@Autowired
	public CmdRunner(CountryService countryService) {
		this.countryService = countryService;
	}

	@Override
	public void run(String... args) throws Exception {
		countryService.getCountryDetails();

	}

}
