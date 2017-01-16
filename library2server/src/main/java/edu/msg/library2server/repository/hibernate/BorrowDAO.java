package edu.msg.library2server.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.msg.library2common.model.Borrow;

public class BorrowDAO {
	public boolean addBorrow(Borrow borrow) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(borrow);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
