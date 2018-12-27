package io.github.julianjupiter.addressbook.util;

import java.util.Map;

public class Validation {
	private Map<String, String> errors;
	
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public boolean hasErrors() {
		return errors != null && errors.size() > 0;
	}
}
