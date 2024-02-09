package org.jsp.shoppingkart.exception;

import org.jsp.shoppingkart.dao.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionalHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setBody("User not found");
		structure.setMessage(e.getMessage());
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleInvalidCredintialException(InValidCredentialException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setBody("Invalid email or phone or password");
		structure.setMessage(e.getMessage());
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
