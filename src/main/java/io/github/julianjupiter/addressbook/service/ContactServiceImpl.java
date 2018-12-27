package io.github.julianjupiter.addressbook.service;

import java.util.List;
import java.util.Optional;

import io.github.julianjupiter.addressbook.dao.ContactDao;
import io.github.julianjupiter.addressbook.dao.ContactDaoImpl;
import io.github.julianjupiter.addressbook.domain.Contact;

public class ContactServiceImpl implements ContactService {
	private ContactDao contactDao;
	
	public ContactServiceImpl() {
		this.contactDao = new ContactDaoImpl();
	}
	
	@Override
	public List<Contact> findAll() {
		return contactDao.findAll();
	}

	@Override
	public Optional<Contact> findById(long id) {
		return contactDao.findById(id);
	}

	@Override
	public void save(Contact contact) {
		contactDao.save(contact);
	}

	@Override
	public void update(Contact contact) {
		contactDao.update(contact);
	}

	@Override
	public void delete(long id) {
		contactDao.delete(id);
	}

}
