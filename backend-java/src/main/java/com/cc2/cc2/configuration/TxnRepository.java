package com.cc2.cc2.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cc2.cc2.entity.PKey;
import com.cc2.cc2.entity.TransactionDetails;

public interface TxnRepository extends JpaRepository<TransactionDetails, PKey> {
	 
}