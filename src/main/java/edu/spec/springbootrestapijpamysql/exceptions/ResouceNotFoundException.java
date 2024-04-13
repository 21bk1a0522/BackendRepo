package edu.spec.springbootrestapijpamysql.exceptions;

public class ResouceNotFoundException extends RuntimeException{
	String message;
	public ResouceNotFoundException(String message){
	this.message = message;
	}
	public String toString() {
	return message;
	}
}
