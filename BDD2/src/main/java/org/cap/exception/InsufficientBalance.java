package org.cap.exception;

public class InsufficientBalance extends Exception{
	public InsufficientBalance  (String message){
		super(message);
	}
	
	public InsufficientBalance (){
		super();
	}
} 


