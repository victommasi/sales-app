package com.victommasi.model;

public class Datapoint {
	
	private String label;
	
	private float x;
	
	private float y;
	
	
	public Datapoint(){}
	
	public Datapoint(String label, float x, float y){
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

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
