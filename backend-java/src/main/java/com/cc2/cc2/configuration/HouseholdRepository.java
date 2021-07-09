package com.cc2.cc2.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cc2.cc2.entity.Households;

public interface HouseholdRepository extends JpaRepository<Households, String> {
	 
}