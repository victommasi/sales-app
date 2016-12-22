package com.victommasi.model;

import java.math.BigDecimal;

public class Balance {

	private BigDecimal total;
	private BigDecimal average;
	
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getAverage() {
		return average;
	}
	public void setAverage(BigDecimal average) {
		this.average = average;
	}
}
