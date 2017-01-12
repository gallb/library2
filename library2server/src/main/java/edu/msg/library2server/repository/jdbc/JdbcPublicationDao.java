package edu.msg.library2server.repository.jdbc;

import java.awt.print.Book;
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
	private SqlHandler conMan;
	public JdbcPublicationDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Publication> getAllPublications() { //egyelore csak book-ra
	return null;
	}
//		List<Publication> list = new ArrayList();
//		Connection con = null;
//		try {
//			con=conMan.getConnection();
//			Statement statemanet = con.createStatement();
//			ResultSet publications = statemanet.executeQuery("select * from books");
//			while (publications.next()) {
//				Book b =new Book();
//				
//				b.setUuid(publications.getString("uuid"));
//				u.set(publications.getString("title"));
//				
//				b.s
//				u.setUserName(publications.getString("user_name"));
//				u.setLoyalityIndex(publications.getInt("loyalty_index"));
//				u.setPassword(publications.getString("password"));
//				u.setUuid(publications.getString("uuid"));
//				list.add(u);				
//			}			
//		} catch (SQLException e) {
//			throw new SqlHandlerException("Could not query Users",e);
//		}
//		return list;
//	}

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
