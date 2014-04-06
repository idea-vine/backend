package com.bigidea.controller;

import java.io.Serializable;

public class ServiceResponse<ERROR, VALUE> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5506544159204157231L;
	private VALUE value;
	private boolean isError;
	private ERROR error;
	
	
	public ERROR getError() {
		return error;
	}

	public void setError(ERROR error) {
		this.error = error;
	}

	public VALUE getValue() {
		return value;
	}

	public void setValue(VALUE value) {
		this.value = value;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	
	
	public ServiceResponse() {
		
	}	
	
	public ServiceResponse(ERROR error, VALUE value,boolean isError){
		this.value = value;
		this.error = error;
		this.isError = isError;
	}

}
