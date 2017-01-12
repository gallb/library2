package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2server.repository.UserDao;

public class JdbcUserDao implements UserDao {
//	private static final Logger LOGGER=LoggerFactory.getLogger(JdbcUserDao.class);
	private SqlHandler conMan;

	public JdbcUserDao() {
		conMan = SqlHandler.getInstance();
	}

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		Connection con = null;
		try {
			System.out.println("belepet");
			con= conMan.getConnection();
			System.out.println("konektelt");
			Statement statemanet = con.createStatement();
			ResultSet users = statemanet.executeQuery("select * from users");
			while (users.next()) {
				User u = new User();
				u.setUuid(users.getString("uuid"));
				u.setName(users.getString("name"));
				u.setUserName(users.getString("user_name"));
				u.setUserType(UserType.valueOf(users.getString("user_type")));
				u.setLoyalityIndex(users.getInt("layalty_index"));
				u.setPassword(users.getString("password"));
				list.add(u);				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
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
//			preparedStatement.setString(4, user.getUserType()); //itt valami baj van
			preparedStatement.setInt(5, user.getLoyalityIndex());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();			
		} catch (SQLException e) {
			throw new SqlHandlerException("Could not insert user. ",e);
		}
		return user;
	}

	public void updateUser(User user) {
//		Connection con = null;
//		try {
//			con = (Connection)conMan.getInstance();
//			PreparedStatement preparedStatement = con.prepareStatement("UPDATE users "
//					+ " SET uuid = ?, name = ?, user_name = ?,user_type = ?, loyalty_index = ?, password = ? "
//					+ " WHERE id = ?"
//					);
//			preparedStatement.setString(1, user.getUuid());
//			preparedStatement.setString(2, user.getFirsName());
//			preparedStatement.setString(3, user.getLastName());
//			preparedStatement.setString(4, user.getEmail());
//			preparedStatement.setString(5, user.getPassword());
//			preparedStatement.setLong(6, user.getId());
//			preparedStatement.execute();
//			LOGGER.info("User Update successful.");
//		} catch (SQLException e) {
//			LOGGER.error("Could not update user",e);
//			throw new RepositoryException("Could not update user. ",e);
//		} finally {
//			if (con != null) {
//				conMan.returnConnection(con);
//			}
//		}
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	
	


}

