package com.mphasis.training.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

public class Address {

	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String street;
	
	//need not map here ,since it is mapped in Employee class
	//@OneToOne(mappedBy="address")
	
	@OneToOne
	@MapsId
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
