package com.touring.accounts.touringaccounts.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.touring.accounts.touringaccounts.model.Accounts;
import com.touring.accounts.touringaccounts.services.AccountServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service/")
public class AccountsController  {
	
	@Value("${spring.application.name}")
    private String serviceId;
	
	@Autowired
    private Environment env;
	
	@GetMapping("port")
    public String getPort(){
        return "Service is working at port : " + env.getProperty("local.server.port");
    }
	
	
	@Autowired
	private AccountServices accountService;

	@GetMapping("findById{id}")
	@ResponseBody
	public Optional<Accounts> findById(@RequestParam( value = "id", required = true )  String id) {

		System.err.println("--------------ID--------------------");
		return accountService.findById(id);
	}
	
	
	/* ------------------------------------------------------------------------------------------------------------------------*/

	@GetMapping(value = "findByFName{firstname}")
	@ResponseBody
	public Iterable<Accounts> findByFirstName(@RequestParam String firstname) {

		System.err.println("-----------------findByFirstName  ");

		// Gson gson = new Gson();

		return accountService.findByFirstname(firstname);
	}
	
	@GetMapping(value = "findByLName{lastname}")
	@ResponseBody
	public Iterable<Accounts> findByLastName(@RequestParam String lastname) {

		System.err.println("-----------------findByLastName  ");

		// Gson gson = new Gson();

		return accountService.findByLastname(lastname);
	}
	
	
	/* ------------------------------------------------------------------------------------------------------------------------*/


	 

	@GetMapping(value = "/findAll")
	public @ResponseBody Iterable<Accounts> findAll()  {

		System.err.println("----------------------findall-----------------------");
		
		Iterable<Accounts> iterable = accountService.findAll();
		
		List<Accounts> result = 
				  StreamSupport.stream(iterable.spliterator(), false)
				    .collect(Collectors.toList());

		return result;
	}

}
	
	
	



