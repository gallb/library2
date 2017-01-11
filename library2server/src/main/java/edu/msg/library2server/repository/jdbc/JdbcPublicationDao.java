package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2server.repository.PublicationDao;

public class JdbcPublicationDao implements PublicationDao {
	public JdbcPublicationDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Publication> getAllPublications() {
		return null;
//		List<User> list = new ArrayList<User>();
//		Connection con = null;
//		try {
//			con=(Connection) conMan.getInstance();
//			Statement statemanet = con.createStatement();
//			ResultSet users = statemanet.executeQuery("select * from users");
//			while (users.next()) {
//				User u = new User();
//				u.setName(users.getString("name"));
//				u.setUserName(users.getString("user_name"));
//				u.setLoyalityIndex(users.getInt("loyalty_index"));
//				u.setPassword(users.getString("password"));
//				u.setUuid(users.getString("uuid"));
//				list.add(u);				
//			}			
//		} catch (SQLException e) {
//			throw new SqlHandlerException("Could not query Users",e);
//		}
//		return list;
	}

	public Publication getPublicationByName(String publication_name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User insertPublication(Publication pub) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePublication(Publication pub) {
		// TODO Auto-generated method stub
		
	}

	public void deletePublication(Publication pub) {
		// TODO Auto-generated method stub
		
	}

}
