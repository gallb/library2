package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2server.repository.UserDao;

public class JdbcUserDao implements UserDao {
//	private static final Logger LOGGER=LoggerFactory.getLogger(JdbcUserDao.class);
	private SqlHandler conMan;

	public JdbcUserDao() {
		conMan = SqlHandler.getInstance();
	}

//	public List<User> getAllUsers() {
//		List<User> list = new ArrayList<User>();
//		Connection con = null;
//		try {
//			con = conMan.getInstance();
//			Statement statemanet = con.createStatement();
//			ResultSet users = statemanet.executeQuery("select * from suma_user");
//			while (users.next()) {
//				User u = new User();
//				u.setFirsName(users.getString("first_name"));
//				u.setLastName(users.getString("last_name"));
//				u.setEmail(users.getString("email"));
//				u.setPassword(users.getString("pasword"));
//				u.setId(users.getLong("id"));
//				u.setUuid(users.getString("uuid"));
//				list.add(u);				
//			}
//			LOGGER.info("Users listed successfully.");
//		} catch (SQLException e) {
//			LOGGER.error("Could not query users",e);
//			throw new RepositoryException("Could not query Users",e);
//		} finally {
//			if (con != null) {
//				conMan.returnConnection(con);
//			}
//		}
//		return list;
//	}

	public User getUserByName(String user_name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	


}

