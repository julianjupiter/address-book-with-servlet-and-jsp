package io.github.julianjupiter.addressbook.exception;

public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 3229113657577735041L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
