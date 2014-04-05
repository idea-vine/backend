package com.bigidea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ideas {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	@OneToMany
	private Integer userId;
	@Column
	private String text;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

}
