package edu.msg.library2server.repository.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Publication;
import edu.msg.library2server.repository.DaoInterface;

public class HibernatePublicationDao implements DaoInterface{
	 public List<Publication> listPublications() {
	        Session session = null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            Query query = session.createQuery("from Publication s");
	 
	          //  System.out.println(query.toString());
	          //  System.out.println(query.getQueryString() + " " + query.getFetchSize());
	         //   System.out.println(query.list().size());
	            List queryList = query.list();
	            /*List <Publication> queryList = new ArrayList();
	            for (Object oneObject : query.getResultList()) {
	                queryList.add((oneObject.
	            }*/
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                return (List<Publication>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }

	public <X extends BaseEntity> List<X> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> List<X> getByName(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> boolean insert(X e) {
		// TODO Auto-generated method stub
		return false;
	}

	public <X extends BaseEntity> boolean update(X e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public <X extends BaseEntity> X getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
