package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>{

	List<Country> findAllByRegion(String region);
	
}
