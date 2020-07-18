package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="stu_seq")
	@SequenceGenerator(sequenceName="student_seq",allocationSize=1,name="stu_seq")
	private int st_id;
	
	@Column(name="stname",length=20,unique=true,nullable=false)
	private String name;
	
	@ElementCollection
	@CollectionTable(name="st_email",joinColumns=@JoinColumn(name="stuid"))	
	private Set<String> email=new HashSet<>();
	
	//(or)private List<String> email=new ArrayList<>();
	//use hashset to allow duplicates
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="lpcode")
	private Laptop lp=new Laptop();
	
	
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getEmail() {
		return email;
	}
	public void setEmail(Set<String> email) {
		this.email = email;
	}
	public Laptop getLp() {
		return lp;
	}
	public void setLp(Laptop lp) {
		this.lp = lp;
	}
	
	
	
}
