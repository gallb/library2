package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author nagys
 *
 */

public class SqlHandler {
	private static final String DBURL = "jdbc:mysql://localhost:3306/library?useSSL=false";
	private static final String USER = "library_admin";
	private static final String PASSWORD = "library_admin_pass";
	private Connection connection;
	private static SqlHandler instance;

	private SqlHandler() {
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlHandlerException("Connection failed", e);
		}
	}

	public static synchronized SqlHandler getInstance() {
		if (instance == null) {
			instance = new SqlHandler();
			System.out.println("server satrt");
		}
		return instance;
	}

}
