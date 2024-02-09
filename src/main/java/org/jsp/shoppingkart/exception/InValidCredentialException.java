package org.jsp.shoppingkart.exception;

public class InValidCredentialException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid credentials";
	}
}
