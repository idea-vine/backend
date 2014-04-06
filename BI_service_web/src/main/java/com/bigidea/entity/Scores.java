package com.bigidea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Scores implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2625579955799215152L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private Integer totalScore;
	@Column
	private Integer totalLikes;
	@Column
	private Integer totalViews;
	@Column
	private Integer totalCounts;
	
	public Scores(Integer totalScore, Integer totalLikes, Integer totalViews, Integer totalCounts){
		this.totalScore = totalScore;
		this.totalLikes = totalLikes;
		this.totalViews = totalViews;
		this.totalCounts = totalCounts;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(Integer totalLikes) {
		this.totalLikes = totalLikes;
	}

	public Integer getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(Integer totalViews) {
		this.totalViews = totalViews;
	}

	public Integer getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(Integer totalCounts) {
		this.totalCounts = totalCounts;
	}

	public Integer getId() {
		return id;
	}

}
