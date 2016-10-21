package com.victommasi.exception;

public class ImpossibleDeleteCustomerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ImpossibleDeleteCustomerException(String msg) {
		super(msg);
	}
}