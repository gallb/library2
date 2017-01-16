package edu.msg.library2server.repository.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.msg.library2common.model.Publication;

public class PublicationDAO {
	 public List<Publication> listPublications() {
	        Session session = null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            Query query = session.createQuery("from Publication s");
	 
	          //  System.out.println(query.toString());
	          //  System.out.println(query.getQueryString() + " " + query.getFetchSize());
	            System.out.println(query.list().size());
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
}
