package com.touring.accounts.touringaccounts.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.touring.accounts.touringaccounts.model.Accounts;



@Repository
public interface AccountRepo extends ElasticsearchRepository<Accounts, String> {

	//@Query("{\"bool\": {\"must\": [{\"match\": {\"firstname\": \"?0\"}}]}}")
	public Iterable<Accounts> findByFirstname(String firstname);
	
	
	public Iterable<Accounts> findByFirstnameStartingWith(String firstname);
	  //Page<Accounts> findByName(String name,Pageable pageable);


	public Iterable<Accounts> findByLastnameStartingWith(String lastname);

	

}