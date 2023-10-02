package com.alissw.regulatory.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public void addErrors(String field, String Message) {
		errors.add(new FieldMessage(field, Message));
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
}
