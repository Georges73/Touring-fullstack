package com.touring.cars.touringcars.controllers;


import org.springframework.web.bind.annotation.RestController;


import com.touring.cars.touringcars.model.Cars;
import com.touring.cars.touringcars.services.CarsService;

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/service/")
//@Api(value = "Product Rest Controller: contains all operations for managing products")
public class CarsController {
	
	@Autowired
	private CarsService carsService;
	
	@Value("${spring.application.name}")
    private String serviceId;
	
	@Autowired
    private Environment env;
	
	@GetMapping("/port")
    public String getPort(){
        return "Service is working at port : " + env.getProperty("local.server.port");
    }
	

	
	// @ResponseStatus(HttpStatus.OK)
	//@ApiOperation(value = "Get All products from DB", response = Product.class)
	//@ApiResponse(code = 409, message = "Conflict: SOmething went wrong")
	@GetMapping("/getAllCars")
	public @ResponseBody Iterable<Cars> allProducts() {
    System.err.println("All cars ");
    
    Iterable<Cars> iterable = carsService.allCars();
	
	List<Cars> result = 
			  StreamSupport.stream(iterable.spliterator(), false)
			    .collect(Collectors.toList());

	return result;

		
	}
	
	
	// @ResponseStatus(HttpStatus.OK)
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
	//@ApiResponse(code = 204, message = "No Content: no result founded"), })
	@GetMapping(value = "searchMakeAutocomplete{prefix}")
	@ResponseBody
	public Iterable<Cars> searchByNameAutoComplete(@RequestParam("prefix") String prefix) {

		System.err.println("searchByNameStartingwith  ");

		
		 Iterable<Cars> iterable = carsService.findByMakeStartingWith(prefix);
			
			List<Cars> result = 
					  StreamSupport.stream(iterable.spliterator(), false)
					    .collect(Collectors.toList());

			return result;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value = "/findByMake{make}", produces = "application/json")
	// @ResponseStatus(HttpStatus.OK)
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
			//@ApiResponse(code = 204, message = "No Content: no result founded"), })
	public Iterable<Cars> searchByName(@RequestParam("make") String make) {

		System.err.println("searchByName  ");

		
		return carsService.findByMake(make);
	}
	
	
	
	
	
	
	@GetMapping("/findById{id}")
	@ResponseBody
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research by ID"),
			//@ApiResponse(code = 204, message = "No Content: no result founded by ID"), })

	public Optional<Cars> findById(@RequestParam("id") Long id) {
		System.err.println("--------------SEARCH BY ID---------------------" + id);

		// Gson gson = new Gson();

		return carsService.findById(id);
	}

}
