package org.cap.exception;

public class AccountNotFound extends Exception{
	public AccountNotFound(String message){
		super(message);
	}
	
	public AccountNotFound(){
		super();
	}
} 


