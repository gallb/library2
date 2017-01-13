package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Book;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.PublicationType;
import edu.msg.library2common.model.Publisher;
import edu.msg.library2server.repository.DaoInterface;
import edu.msg.library2server.repository.PublicationDao;

public class JdbcPublicationDao implements PublicationDao {
	private SqlHandler conMan;
	public JdbcPublicationDao() {
		conMan = SqlHandler.getInstance();
	}

	public List<Publication> getAll() {							 //egyelore csak book-ra
		List<Publication> list = new ArrayList();
		Connection con = null;
		try {
			con=conMan.getConnection();
			Statement statemanet = con.createStatement();
			ResultSet publications = statemanet.executeQuery("select * from publications");
			while (publications.next()) {			
				String title=publications.getString("title");
				Date date=publications.getDate("publication_date");
				Publisher publisher =new Publisher( publications.getString("publisher_id"));
				int nrOfCopies= publications.getInt("nr_of_copys");
				int onStock=publications.getInt("on_stock");
				Book b =new Book( title,  date,  publisher,  nrOfCopies,  onStock);
				list.add(b);				
			}			
		} catch (SQLException e) {
			throw new SqlHandlerException("Could not query Books",e);
		}
		return list;
	}

	public Publication getPublicationByTitleAndType(String publication_title, PublicationType pub_type) {
		// TODO Auto-generated method stub
		return null;
	}
	public Publication getPublicationByTitleAndType(String publication_title, Publication pub_type) {
		// TODO Auto-generated method stub
		return null;
	}	

	public <X extends BaseEntity> void update(X e) {
		// TODO Auto-generated method stub
	//String title = ((Publication)e).getTitle();
		
	}

	public <X extends BaseEntity> X getOne(String publication_title) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> X insert(X e) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> void delete(X e) {
		// TODO Auto-generated method stub
		
	}

}
