package com.example.demo.services.impl;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dtos.CountryDto;
import com.example.demo.model.entities.Country;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	private final ModelMapper modelMapper;
	private final CountryRepository countryRepository;

	@Autowired
	public CountryServiceImpl(ModelMapper modelMapper, CountryRepository countryRepository) {
		this.modelMapper = modelMapper;
		this.countryRepository = countryRepository;

	}

	@Override
	public void getCountryDetails() throws IOException {

		Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/#c-asia").get();

		List<Element> countryContent = doc.getElementsByTag("tr");

		countryContent.stream().forEach(country -> {
			if (!country.attr("style").equals("display: none")) {

				CountryDto countryDto = new CountryDto();

				String countryName = country.childNodes().get(3).childNodes().get(0).childNodes().toString();
				int totalCases = getTotalNumbers(country.childNodes().get(5).childNodes().toString());
				int activeCases = getTotalNumbers(country.childNodes().get(17).childNodes().toString());
				int totalTests = getTotalNumbers(country.childNodes().get(25).childNodes().toString());

				if (!countryName.equals("[]") && !countryName.isEmpty()) {
					
					countryDto.setName(countryName.substring(1, countryName.length() - 1))
					          .setTotalCases(totalCases)
					          .setActiveCases(activeCases)
					          .setTotalTests(totalTests);

					countryRepository.save(modelMapper.map(countryDto, Country.class));
				}
			}
		});

		System.out.println();
//		countryContent.get(15).childNodes().stream().forEach(n -> System.out.println(n));
//		System.out.println(countryContent.get(15).childNodes().get(1).childNodes().get(0));
//		.stream()
//		.forEach(n -> n.childNodes()
//				.stream()
//				.forEach(child -> System.out.println(child.)));
//		n.attr("data-continent")

	}

	public int getTotalNumbers(String cases) {
		String temp = cases.substring(1, cases.length() - 1);

		System.out.println();
		if (!temp.equals("Total, <br>, Cases") && !temp.equals("Total, <br>, Tests")
				&& !temp.equals("Active, <br>, Cases") && !temp.equals("N/A") && !temp.isEmpty()) {
			String total = temp.replace(",", "");

			return Integer.parseInt(total.trim());
		} else {
			return 0;
		}
	}
}
