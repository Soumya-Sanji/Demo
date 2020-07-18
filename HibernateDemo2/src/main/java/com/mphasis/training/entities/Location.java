package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Location {

	@Id
	private String lcode;
	@Column(length=10,unique=true)
	private String lname;
	
	@OneToMany(mappedBy="loc",fetch=FetchType.EAGER)
	private List<Department> deps=new ArrayList<>();
	
	//this does not appear in database,available only on java side
	@Transient
	private int pincode;
	
	public List<Department> getDeps() {
		return deps;
	}

	public void setDeps(List<Department> deps) {
		this.deps = deps;
	}

	public String getLcode() {
		return lcode;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	
}
