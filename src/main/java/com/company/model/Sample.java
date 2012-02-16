package com.company.model;

import javax.persistence.Id;

public class Sample {
	
	@Id Long id;
	String name;
	
	public Sample() {}
	
	public Sample(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
