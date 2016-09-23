package com.victommasi.model;

public enum Status {
	
	REFUSED(0, "Recusado"),
	ACCEPTED(1, "Aceito"),
	NEGOCIATING(2, "Em negociação");
	
	private Integer id;
	private String desc;
	
	Status(Integer id, String desc){
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
