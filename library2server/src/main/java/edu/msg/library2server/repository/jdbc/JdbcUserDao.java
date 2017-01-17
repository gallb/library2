package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.util.PasswordEncrypter;

public class JdbcUserDao implements UserDao {
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
			con = conMan.getConnection();
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
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_query"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return list;
	}

	public List<User> getByName(String name) {
		List<User> list = new ArrayList<User>();
		User user = null;
		try {
			con = conMan.getConnection();
			String selectSQL = "select * from users where name=?";
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);
			ResultSet users = preparedStatement.executeQuery();
			while (users.next()) {
				user = new User();
				user.setUuid(users.getString("uuid"));
				user.setName(users.getString("name"));
				user.setUserName(users.getString("user_name"));
				user.setUserType(UserType.valueOf(users.getString("user_type")));
				user.setLoyalityIndex(users.getInt("loyalty_index"));
				user.setPassword(users.getString("password"));
				list.add(user);
			}

		} catch (SQLException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_query"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return list;
	}

	public boolean insert(BaseEntity ent) {
		boolean returnStatus = false;
		User user = (User) ent;
		User us = new User();
		try {
			con = conMan.getConnection();
			System.out.println(con.isClosed());
			String sqlCommand = "insert into users (uuid, name, user_name, user_type, loyalty_index, password) "
					+ "values (?, ?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(sqlCommand);
			preparedStatement.setString(1, user.getUuid());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getUserType().name());
			preparedStatement.setInt(5, user.getLoyalityIndex());
			user.setPassword(PasswordEncrypter.encypted(user.getPassword(), " "));
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.executeUpdate();
			LOGGER.info("User inserted!");
			returnStatus = true;
		} catch (SQLException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_insert"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return returnStatus;
	}

	public <X extends BaseEntity> boolean update(X ent) {
		User user = (User) ent;
		boolean returnStatus = false;
		try {
			con = conMan.getConnection();
			String sqlCommand = "UPDATE users " + " SET name = ?, user_name = ?,user_type = ?,"
					+ " loyalty_index = ?, password = ? " + " WHERE uuid = ?";
			preparedStatement = con.prepareStatement(sqlCommand);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserType().name());
			preparedStatement.setInt(4, user.getLoyalityIndex());
			user.setPassword(PasswordEncrypter.encypted(user.getPassword(), " "));
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getUuid());
			preparedStatement.executeUpdate();
			returnStatus = true;
		} catch (SQLException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_update"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return returnStatus;
	}

	public boolean delete(String id) {
		boolean returnStatus = false;
		try {
			con = conMan.getConnection();
			String sqlCommand = "delete from users WHERE uuid = ?";
			preparedStatement = con.prepareStatement(sqlCommand);
			preparedStatement.setString(1, id);
			preparedStatement.execute();
			LOGGER.info(PropertyProvider.INSTANCE.getProperty("info.logger.jdbc_user_dao"));
			returnStatus = true;
		} catch (SQLException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_delete"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return returnStatus;
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
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_query"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return user;

	}

	public User getById(String id) {
		User user = null;
		try {
			con = conMan.getConnection();
			String selectSQL = "select * from users where uuid=?";
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
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
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_query"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return user;
	}

	private void closeConnection(Connection con, PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_close"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
	}

}
