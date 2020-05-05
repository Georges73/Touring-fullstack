package com.touring.cars.touringcars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touring.cars.touringcars.model.Cars;
import com.touring.cars.touringcars.repo.Carsrepo;

@Transactional
@Service("CarsService")
public class CarsServiceImplement implements CarsService{
	
	 @Autowired
	    private Carsrepo carsrepo;

	@Override
	public Iterable<Cars> allCars() {
		// TODO Auto-generated method stub
		return carsrepo.findAll(PageRequest.of(0, 50));
	}

	@Override
	public Optional<Cars> findById(Long id) {
		// TODO Auto-generated method stub
		return carsrepo.findById(id);
	}

	@Override
	public Iterable<Cars> findByMakeStartingWith(String keyword) {
		// TODO Auto-generated method stub
		Pageable firstPageWith20Elements = PageRequest.of(0, 15);
		//Page<Cars> allProducts = 
		
		return carsrepo.findByMakeStartingWith(keyword, firstPageWith20Elements);
	}

	@Override
	public List<String> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Cars> findByMake(String make) {
		// TODO Auto-generated method stub
		return carsrepo.findByMake(make);
	}

	@Override
	public Iterable<Cars> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cars> searchAutocomplete(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 

	

	

}
