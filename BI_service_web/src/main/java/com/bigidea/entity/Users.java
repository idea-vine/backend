package com.bigidea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;





@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String fname;
	
	@Column
	private String lname;

	@Column(unique = true, nullable=false)
	private String email;
	
	public Integer getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
