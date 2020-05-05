package com.touring.cars.touringcars.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.touring.cars.touringcars.model.Cars;

public interface  Carsrepo extends PagingAndSortingRepository<Cars, Long> {
	
	
	
	List<Cars> findAll();

	//@Query("SELECT name FROM Cars where make like %:keyword%")
	public List<Cars> findByMakeStartingWith(String keyword, Pageable pageable);
	
	
	
	//@Query("SELECT make FROM Cars where make like %:keyword%")
	//public List<Cars> searchAutocomplete(String keyword);

	Iterable<Cars> findByMake(String make);

}
