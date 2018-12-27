package io.github.julianjupiter.addressbook.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.julianjupiter.addressbook.domain.Contact;

public class ContactValidator implements Validator<Contact> {

	@Override
	public Validation validate(Contact contact) {
		Validation validation = new Validation();
		Map<String, String> errors = new HashMap<>();
		
		if (contact.getFirstName() == null || contact.getFirstName().isEmpty())
			errors.put("firstName", "First Name must not be empty.");
		
		if (contact.getLastName() == null || contact.getLastName().isEmpty())
			errors.put("lastName", "Last Name must not be empty.");
		
		if (contact.getMobileNumber() == null || contact.getMobileNumber().isEmpty())
			errors.put("mobileNumber", "Mobile Number must not be empty.");
		
		if (contact.getEmailAddress() != null && !contact.getEmailAddress().isEmpty()  && !isValidEmailAddress(contact.getEmailAddress())) {
			errors.put("emailAddress", "Email Address is invalid.");
		}
		
		if (contact.getAddress() == null || contact.getAddress().isEmpty())
			errors.put("address", "Address must not be empty.");
		
		validation.setErrors(errors);
		
		return validation;
	}
	
	public boolean isValidEmailAddress(String email) {
        String expression = "^.+@.+\\..+$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
	}
}
