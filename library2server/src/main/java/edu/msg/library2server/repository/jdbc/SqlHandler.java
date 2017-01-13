package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.msg.library2server.util.PropertyProvider;

/**
 * 
 * @author nagys
 *
 */

public class SqlHandler {
	private static final String DBURL = PropertyProvider.INSTANCE.getProperty("mysql.url");
	private static final String USER = PropertyProvider.INSTANCE.getProperty("mysql.user");
	private static final String PASSWORD = PropertyProvider.INSTANCE.getProperty("mysql.password");	
	
	private Connection connection;
	private static SqlHandler instance;

	private SqlHandler() {
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
			System.out.println("connected");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlHandlerException("Connection failed", e);
		}
	}

	public static synchronized SqlHandler getInstance() {
		if (instance == null) {
			instance = new SqlHandler();
			System.out.println("server start");
		}
		return instance;
	}

	public Connection getConnection() {
		Connection con = null;
		con = connection;

		return con;
	}

}
