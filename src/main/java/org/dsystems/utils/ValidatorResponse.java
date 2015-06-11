package org.dsystems.utils;

public class ValidatorResponse {

	public boolean isValid;
	public String message;
	
	public ValidatorResponse(boolean isValid, String message) {
		super();
		this.isValid = isValid;
		this.message = message;
	}
	
}
