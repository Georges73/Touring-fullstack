package com.touring.accounts.touringaccounts.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.touring.accounts.touringaccounts.model.Accounts;

@Service
public interface AccountServices {
	
	Optional<Accounts> findById(String id);

	Iterable<Accounts> findAll();

	Iterable<Accounts> findByFirstname(String firstname);

	Iterable<Accounts> findByLastname(String lastname);
	
	
}