package com.bigidea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4729567069977681035L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String fname;
	
	@Column
	private String lname;

	@Column(unique = true, nullable=false)
	private String email;
	
	public Users(Integer id){
		this.id = id;
	}
	
	public Users(){
		
	}
	
	public Users(String fname, String lname, String email){
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
