package com.touring.cars.touringcars.services;

import java.util.List;
import java.util.Optional;

import com.touring.cars.touringcars.model.Cars;

public interface CarsService {
	
	Iterable<Cars> allCars();
	
	Optional<Cars> findById(Long id);
	
	Iterable<Cars> findByMakeStartingWith(String keyword);
	 
	 public List<String> search(String keyword);
	 
	 public Iterable<Cars> findByMake(String name);
	 
	 Iterable<Cars> findAll();

	List<Cars> searchAutocomplete(String prefix);

	   // List<Transaction> findTransactionsOfUser(Long userId);

	   // List<Transaction> findTransactionsOfCourse(Long courseId);

	    //Transaction saveTransaction(Transaction transaction);

}
