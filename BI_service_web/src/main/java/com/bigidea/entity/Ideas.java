package com.bigidea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ideas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7043323266173476722L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private Integer userId;
	@Column
	private String title;
	@Column
	private String desc;
	@Column
	private String fullText;
	@OneToOne
	@JoinColumn(name = "scoreId")
	private Scores scores;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

}
