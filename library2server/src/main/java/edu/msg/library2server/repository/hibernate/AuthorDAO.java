package edu.msg.library2server.repository.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.msg.library2common.model.Author;

public class AuthorDAO {
	public List<Author> listAuthors() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Author s");
            System.out.println(query.list().size());
            List queryList = query.list();
            System.out.println("list utan " + query.list().size());
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<Author>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
