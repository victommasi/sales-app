package com.victommasi.model;

import java.math.BigDecimal;

public class Datapoint {
	
	private String label;
	
	private Integer x;
	
	private BigDecimal y;
	
	
	public Datapoint(){}
	
	public Datapoint(String label, Integer x, BigDecimal y){
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public BigDecimal getY() {
		return y;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

}
