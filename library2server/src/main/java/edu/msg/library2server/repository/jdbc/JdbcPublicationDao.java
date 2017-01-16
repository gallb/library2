package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Book;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.PublicationType;
import edu.msg.library2common.model.Publisher;
import edu.msg.library2server.repository.DaoInterface;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.service.BasicLoginService;

public class JdbcPublicationDao implements PublicationDao {
	private SqlHandler conMan;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicLoginService.class);
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

	public <X extends BaseEntity> boolean update(X e) {
		// TODO Auto-generated method stub
	//String title = ((Publication)e).getTitle();
		return false;
	}	

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public <X extends BaseEntity> boolean insert(X e) {
		// TODO Auto-generated method stub
		return false;
	}

	public <X extends BaseEntity> List<X> getByName(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> X getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Publication> searchPublications(String regularExpression) {
		// TODO Auto-generated method stub
		return null;
	}

}
