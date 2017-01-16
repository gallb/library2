package edu.msg.library2server.repository.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Publication;
import edu.msg.library2server.repository.PublicationDao;

public class HibernatePublicationDAO implements PublicationDao{
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
	                //System.out.println("list " + queryList);
	                return (List<Publication>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }
	 
	 public List<Publication> searchPublications(String regularExpression) {
	        Session session = null;
	        List<Publication> searchResult= null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            /*List list = session.createCriteria(Publication.class)
	            					.setProjection(Projections.property("title"))
	            					.add(Restrictions.and(Restrictions.sqlRestriction(title REGEXP '*'))).list();*/
	            //List list = session.createCriteria(Publication.class).add(Restrictions.sqlRestriction("REGEXP " + regularExpression)).list();
	            //String sqlQuery = "from Publication p where p.title REGEXP '" + regularExpression + "'";
	           List list = session.createCriteria(Publication.class)
	            		   .add(Restrictions.like("title", regularExpression)).list();
	          //  Query query = session.createQuery(sqlQuery);
	           // List list = query.list();
	            if (list != null) {
	            	return (List<Publication>) list;
	            }
	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }
	 public void updatePublication(Publication pub) {
	        Session session = null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            System.out.println(pub.getTitle() + " " + pub.getOnStock());
	            Transaction t = session.beginTransaction();
	            session.saveOrUpdate(pub);
	          //  session.update(pub);
	            session.flush();
	            t.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
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

	public Publication getPublicationByTitleAndType(String publication_title, Publication pub_type) {
		// TODO Auto-generated method stub
		return null;
	}
}
