package io.github.julianjupiter.addressbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import io.github.julianjupiter.addressbook.domain.Contact;
import io.github.julianjupiter.addressbook.util.Database;

public class ContactDaoImpl implements ContactDao {
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String QUERY_ALL = "SELECT * FROM contact";
	private static final String QUERY_BY_ID = "SELECT * FROM contact WHERE id = ?";
	private static final String QUERY_SAVE = "INSERT INTO contact(first_name, last_name, mobile_number, email_address, address) VALUES(?, ?, ?, ?, ?)";
	private static final String QUERY_UPDATE = "UPDATE contact SET first_name = ?, last_name = ?, mobile_number = ?, email_address = ?, address = ? WHERE id = ?";
	private static final String QUERY_DELETE_BY_ID = "DELETE FROM contact WHERE id = ?";

	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = new ArrayList<>();
		
		try (Connection connection = Database.getDBConnection();
			PreparedStatement statement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getLong("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setMobileNumber(resultSet.getString("mobile_number"));
				contact.setEmailAddress(resultSet.getString("email_address"));
				contact.setAddress(resultSet.getString("address"));
				contacts.add(contact);
			}
			
		} catch (Exception exception) {
			LOGGER.severe(exception.getMessage());
		}
		
		return contacts;
	}

	@Override
	public Optional<Contact> findById(long id) {
		ResultSet resultSet = null;
		
		try (Connection connection = Database.getDBConnection();
			PreparedStatement statement = connection.prepareStatement(QUERY_BY_ID);) {			
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getLong("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setMobileNumber(resultSet.getString("mobile_number"));
				contact.setEmailAddress(resultSet.getString("email_address"));
				contact.setAddress(resultSet.getString("address"));
				
				return Optional.ofNullable(contact);
			}			
		} catch (Exception exception) {
			LOGGER.severe(exception.getMessage());
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException sqlException) {
					LOGGER.severe(sqlException.getMessage());
				}
			}
		}
		
		return Optional.empty();
	}

	@Override
	public void save(Contact contact) {		
		try (Connection connection = Database.getDBConnection();
			PreparedStatement statement = connection.prepareStatement(QUERY_SAVE);) {	
			int counter = 1;
			statement.setString(counter++, contact.getFirstName());
			statement.setString(counter++, contact.getLastName());
			statement.setString(counter++, contact.getMobileNumber());
			statement.setString(counter++, contact.getEmailAddress());
			statement.setString(counter++, contact.getAddress());
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			LOGGER.severe(sqlException.getMessage());
		}
	}

	@Override
	public void update(Contact contact) {
		try (Connection connection = Database.getDBConnection();
				PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);) {
			int counter = 1;
			statement.setString(counter++, contact.getFirstName());
			statement.setString(counter++, contact.getLastName());
			statement.setString(counter++, contact.getMobileNumber());
			statement.setString(counter++, contact.getEmailAddress());
			statement.setString(counter++, contact.getAddress());
			statement.setLong(counter++, contact.getId());
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			LOGGER.severe(sqlException.getMessage());
		}
	}

	@Override
	public void delete(long id) {
		try (Connection connection = Database.getDBConnection();
				PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_BY_ID);) {
			int counter = 1;
			statement.setLong(counter++, id);
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			LOGGER.severe(sqlException.getMessage());
		}
	}

}
