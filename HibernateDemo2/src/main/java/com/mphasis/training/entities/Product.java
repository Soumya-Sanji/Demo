package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Product {

	@Id
	private int pid;
	
	private String pname;
	
	private int cost;
	
	@OneToMany
	private List<Person> persons=new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="oid")
	private Orders od=new Orders();

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Orders getOd() {
		return od;
	}

	public void setOd(Orders od) {
		this.od = od;
	}
	
	
}
