package com.touring.cars.touringcars.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "vehiclemodelyear")
public class Cars implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private Long year;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;
    
    

	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cars(Long id, Long year, String make, String model) {
		super();
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getYear() {
		return year;
	}



	public void setYear(Long year) {
		this.year = year;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}

    
}
