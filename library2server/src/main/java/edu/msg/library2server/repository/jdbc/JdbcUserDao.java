package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2server.repository.UserDao;

public class JdbcUserDao implements UserDao {
//	private static final Logger LOGGER=LoggerFactory.getLogger(JdbcUserDao.class);
	private SqlHandler conMan;

	public JdbcUserDao() {
	//	conMan = SqlHandler.getInstance();
	}

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		Connection con = null;
		try {
			con=(Connection) conMan.getInstance();
			Statement statemanet = con.createStatement();
			ResultSet users = statemanet.executeQuery("select * from users");
			while (users.next()) {
				User u = new User();
				u.setName(users.getString("name"));
				u.setUserName(users.getString("user_name"));
				u.setLoyalityIndex(users.getInt("loyalty_index"));
				u.setPassword(users.getString("password"));
				u.setUuid(users.getString("uuid"));
				list.add(u);				
			}			
		} catch (SQLException e) {
			throw new SqlHandlerException("Could not query Users",e);
		}
		return list;
	}

	public User getUserByName(String user_name) {
		User user=new User();
		List<User> list=getAllUsers();
		for(User u:list){
			if (u.getName().equals(user_name)) {
				user=u;
				break;
			}
		}
		return user;
	}

	public User insertUser(User user) {
		Connection con = null;
		try {
			con = (Connection)conMan.getInstance();
			PreparedStatement preparedStatement = con.prepareStatement("insert into users "
					+ "(uuid, name, user_name, user_type,loyalty_index, pasword) " + "values (?, ?, ?, ?, ?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUuid());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setInt(4, user.getLoyalityIndex());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();			
		} catch (SQLException e) {
			throw new SqlHandlerException("Could not insert user. ",e);
		}
		return user;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	
	


}

