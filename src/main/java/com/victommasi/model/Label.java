package com.victommasi.model;

public enum Label {
	
	JANUARY(1, "janeiro"),
	FEBRUARY(2, "fevereiro"),
	MARCH(3, "março"),
	APRIL(4, "abril"),
	MAY(5, "maio"),
	JUNE(6, "junho"),
	JULY(7, "julho"),
	AUGUST(8, "agosto"),
	SEPTEMBER(9, "setembro"),
	OCTOBER(10, "outubro"),
	NOVEMBER(11, "novembro"),
	DECEMBER(12, "dezembro");
	
	private Integer id;
	private String desc;
	
	Label(Integer id, String desc){
		this.id = id;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public Integer getId() {
		return id;
	}

}
