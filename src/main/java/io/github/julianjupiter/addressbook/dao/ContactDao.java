package io.github.julianjupiter.addressbook.dao;

import java.util.List;
import java.util.Optional;

import io.github.julianjupiter.addressbook.domain.Contact;

public interface ContactDao {
	
    List<Contact> findAll();

    Optional<Contact> findById(long id);

    void save(Contact contact);

    void update(Contact contact);

    void delete(long id);
    
}
