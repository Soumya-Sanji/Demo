package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	private int deptcode;
	
	@Column(length=12)
	private String dname;
	
	@ManyToOne
	@JoinColumn(name="lcode")
	private Location loc=new Location();

//	@OneToMany(mappedBy="dept")
//	private List<Employee> emp=new ArrayList<>();
//	
//	public List<Employee> getEmp() {
//		return emp;
//	}
//
//	public void setEmp(List<Employee> emp) {
//		this.emp = emp;
//	}

	
	public int getDeptcode() {
		return deptcode;
	}

	public Department(int deptcode, String dname, Location loc) {
	super();
	this.deptcode = deptcode;
	this.dname = dname;
	this.loc = loc;
}

	public void setDeptcode(int deptcode) {
		this.deptcode = deptcode;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	
}
