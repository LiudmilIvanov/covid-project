package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

	Region findByName(String name);
	
}
