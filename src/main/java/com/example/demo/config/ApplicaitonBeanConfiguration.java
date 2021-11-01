package com.example.demo.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicaitonBeanConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	BufferedReader bufferedReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
	
}
