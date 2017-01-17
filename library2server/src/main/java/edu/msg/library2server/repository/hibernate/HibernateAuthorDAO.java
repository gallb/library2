package edu.msg.library2server.repository.hibernate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.jdbc.JdbcUserDao;

public class HibernateAuthorDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUserDao.class);
	private PreparedStatement preparedStatement;
	
	public List<Author> listAuthors() {
        Session session = null;
        List author=new ArrayList<Author>();
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Author s");
            System.out.println(query.list().size());
            List queryList = query.list();
            System.out.println("list utan " + query.list().size());
            if (!(queryList == null && queryList.isEmpty())) {
                System.out.println("list " + queryList);
                author=(List<Author>) queryList;               
            }     
            return author;
        } catch (Exception e) {
        	LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.hibernateAuthorDAO.getAll"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.hibernateAuthorDAO.getAll"));
        } finally {
            session.close();
        }
        
    }
}
