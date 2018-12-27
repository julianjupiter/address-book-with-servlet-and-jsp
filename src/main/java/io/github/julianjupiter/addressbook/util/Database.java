package io.github.julianjupiter.addressbook.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/servletjsp";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	private Database() {}

	public static Connection getDBConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage());
		}

		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return connection;
		} catch (SQLException exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage());
		}

		return connection;
	}

}
