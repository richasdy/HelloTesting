package com.richasdy.HelloTesting.TestNG;

public class OrderUpdateException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public OrderUpdateException(){}
	
	public OrderUpdateException(String message){
		super(message);
	}
	
}