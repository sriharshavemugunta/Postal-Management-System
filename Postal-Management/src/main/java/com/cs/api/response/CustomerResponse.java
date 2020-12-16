package com.cs.api.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4062295367768701207L;

	@JsonProperty("customer_id")
	private Integer id;
	
	@JsonProperty("customer_name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
