package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.service.BasicLoginService;

public class JdbcUserDao implements UserDao {
	// private static final Logger
	// LOGGER=LoggerFactory.getLogger(JdbcUserDao.class);
	private SqlHandler conMan;
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUserDao.class);
	private PreparedStatement preparedStatement;
	private Connection con = null;

	public JdbcUserDao() {
		conMan = SqlHandler.getInstance();
	}

	public List<User> getAll() {
		List<User> list = new ArrayList<User>();

		try {
			System.out.println("User logged in.");
			con = conMan.getConnection();
			System.out.println("Connection established!");

			String selectSQL = "select * from users";
			preparedStatement = con.prepareStatement(selectSQL);

			ResultSet users = preparedStatement.executeQuery(selectSQL);
			while (users.next()) {
				User u = new User();
				u.setUuid(users.getString("uuid"));
				u.setName(users.getString("name"));
				u.setUserName(users.getString("user_name"));
				u.setUserType(UserType.valueOf(users.getString("user_type")));
				u.setLoyalityIndex(users.getInt("loyalty_index"));
				u.setPassword(users.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlHandlerException("Could not query Users!", e);

		} finally {
			//closeConnection(con, preparedStatement);
		}
		return list;
	}

	public User getOne(String name) {
		User user = null;
		try {
			con = conMan.getConnection();
			String selectSQL = "select * from users where name=?";
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);
			preparedStatement.execute();
			ResultSet users = preparedStatement.executeQuery(selectSQL);
			while (users.next()) {
				user = new User();
				user.setUuid(users.getString("uuid"));
				user.setName(users.getString("name"));
				user.setUserName(users.getString("user_name"));
				user.setUserType(UserType.valueOf(users.getString("user_type")));
				user.setLoyalityIndex(users.getInt("loyalty_index"));
				user.setPassword(users.getString("password"));
			}

		} catch (SQLException e) {
			LOGGER.error("Could not delete user", e);
			// throw new RepositoryException("Could not update user. ", e);
		} finally {
			//closeConnection(con, preparedStatement);
		}
		return user;
	}

	public void insert(BaseEntity ent) {
		User user = (User) ent;
		User us = new User();
		System.out.println("inside insert");
		try {
			con = conMan.getConnection();
			System.out.println(con.isClosed());
			String sqlCommand = "insert into users (uuid, name, user_name, user_type, loyalty_index, password) " 
													+ "values (?, ?, ?, ?, ?, ?)";
			System.out.println(sqlCommand + " " + user.getName());
			preparedStatement = con.prepareStatement(sqlCommand);
			System.out.println(sqlCommand + " " + preparedStatement.toString());
			preparedStatement.setString(1, user.getUuid());
			System.out.println("id");
			preparedStatement.setString(2, user.getName());
			System.out.println("name");
			preparedStatement.setString(3, user.getUserName());
			System.out.println("uname");
			preparedStatement.setString(4, user.getUserType().name());
			System.out.println("type");
			preparedStatement.setInt(5, user.getLoyalityIndex());
			System.out.println("loyalty");
			preparedStatement.setString(6, user.getPassword());
	
			System.out.println("sql " + preparedStatement.toString() + " " + user.getName());
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			LOGGER.error("Could not insert user. ", e);
			throw new SqlHandlerException("Could not insert user. ", e);
		} finally {
			//closeConnection(con, preparedStatement);
		}		
	}

	public <X extends BaseEntity> void update(X ent) {
		User user = (User) ent;

		try {
			con = conMan.getConnection();
			String sqlCommand = "UPDATE users " + " SET name = ?, user_name = ?,user_type = ?,"
					+ " loyalty_index = ?, password = ? " + " WHERE uuid = ?";
			preparedStatement = con.prepareStatement(sqlCommand);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setObject(3, user.getUserType());
			preparedStatement.setInt(4, user.getLoyalityIndex());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, "'" + user.getUuid() + "'");
			preparedStatement.executeUpdate();
System.out.println("User Update successful");
			LOGGER.info("User Update successful.");
		} catch (SQLException e) {
			LOGGER.error("Could not update user", e);
			System.out.println("User Update NOT successful");
			// throw new RepositoryException("Could not update user. ", e);
		} finally {
			//closeConnection(con, preparedStatement);
		}

	}

	public void delete(String id) {
		
		try {
			con = conMan.getConnection();
			String sqlCommand = "delete * from users WHERE uuid = ?";
			preparedStatement = con.prepareStatement(sqlCommand);
			preparedStatement.setString(1, id);
			preparedStatement.execute();

			LOGGER.info("User deletion successful.");
		} catch (SQLException e) {
			LOGGER.error("Could not delete user", e);
			// throw new RepositoryException("Could not update user. ", e);
		} finally {
			//closeConnection(con, preparedStatement);
		}

	}

	public User getUserByUserName(String user_name) {
		User user = null;
		try {
			con = conMan.getConnection();
			String selectSQL = "select * from users where user_name=?";
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setString(1, user_name);

			ResultSet users = preparedStatement.executeQuery();
			while (users.next()) {
				user = new User();
				user.setUuid(users.getString("uuid"));
				user.setName(users.getString("name"));
				user.setUserName(users.getString("user_name"));
				user.setUserType(UserType.valueOf(users.getString("user_type")));
				user.setLoyalityIndex(users.getInt("loyalty_index"));
				user.setPassword(users.getString("password"));
			}
		} catch (SQLException e) {
			LOGGER.error("Could not retrieve user", e);
			// throw new RepositoryException("Could not update user. ", e);
		} finally {
			//closeConnection(con, preparedStatement);
		}
		return user;

	}

	private void closeConnection(Connection con, PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
