package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	private int oid;
	
	private int totalcost;
	
	@ManyToOne
	@JoinColumn(name="personid")
	private Person p=new Person();
	
	@OneToMany
	private List<Product> prod=new ArrayList<>();

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public List<Product> getProd() {
		return prod;
	}

	public void setProd(List<Product> prod) {
		this.prod = prod;
	}
	
	
}
