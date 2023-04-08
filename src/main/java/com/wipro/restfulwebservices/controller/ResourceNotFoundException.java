package com.wipro.restfulwebservices.controller;

public class ResourceNotFoundException extends Exception {
	String msg;

	public ResourceNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
