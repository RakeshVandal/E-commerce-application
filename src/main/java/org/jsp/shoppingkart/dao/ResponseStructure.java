package org.jsp.shoppingkart.dao;



import lombok.Data;
@Data
public class ResponseStructure<T> {
	private String message;
	private int code;
	private T body;
}

