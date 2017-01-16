package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.util.PropertyProviderServer;

/**
 * 
 * @author nagys
 *
 */

public class SqlHandler {
	private static final String DBURL = PropertyProviderServer.INSTANCE.getProperty("mysql.url");
	private static final String USER = PropertyProviderServer.INSTANCE.getProperty("mysql.user");
	private static final String PASSWORD = PropertyProviderServer.INSTANCE.getProperty("mysql.password");	
	
	private Connection connection;
	private static SqlHandler instance;

	private SqlHandler() {
		try {
			System.out.println(DBURL);
			System.out.println(USER);
			System.out.println(PASSWORD);
			connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
			System.out.println(PropertyProvider.INSTANCE.getProperty("server.message.connected"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlHandlerException(PropertyProvider.INSTANCE.getProperty("error.sql_handler"), e);
		}
	}

	public static synchronized SqlHandler getInstance() {
		if (instance == null) {
			instance = new SqlHandler();
			System.out.println(PropertyProvider.INSTANCE.getProperty("server.message.server_start"));
		}
		return instance;
	}

	public Connection getConnection() {
		Connection con = null;
		con = connection;

		return con;
	}

}
