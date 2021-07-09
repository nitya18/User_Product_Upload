package com.cc2.cc2.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cc2.cc2.entity.TransactionDetails;
import com.cc2.cc2.entity.UserDetails;

public interface CloudRepository extends JpaRepository<UserDetails, String> {
	 
}
