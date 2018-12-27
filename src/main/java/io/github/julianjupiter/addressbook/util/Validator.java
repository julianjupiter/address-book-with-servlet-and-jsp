package io.github.julianjupiter.addressbook.util;

public interface Validator<T> {

	Validation validate(T t);
	
}
