package com.touring.accounts.touringaccounts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.touring.accounts.touringaccounts.model.Accounts;
import com.touring.accounts.touringaccounts.repo.AccountRepo;

@Service("AccountService")
public class AccountServiceImpl implements AccountServices{
	
	@Autowired
	private AccountRepo accountRepo;
	
	
	public Optional<Accounts> findById(String id) {
		// TODO Auto-generated method stub
		return accountRepo.findById(id);
	}


	@Override
	public Iterable<Accounts> findAll() {
		// TODO Auto-generated method stub
		return accountRepo.findAll(PageRequest.of(0, 50));
		//return accountRepo.findAll();
	}


	@Override
	public Iterable<Accounts> findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return accountRepo.findByFirstnameStartingWith(firstname);
	}


	@Override
	public Iterable<Accounts> findByLastname(String lastname) {
		// TODO Auto-generated method stub
		return accountRepo.findByLastnameStartingWith(lastname);
	}
	
}