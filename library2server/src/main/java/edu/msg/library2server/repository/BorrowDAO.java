package edu.msg.library2server.repository;

import java.sql.Date;
import java.util.List;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

public interface BorrowDAO extends DaoInterface<Borrow> {
	/**
	 * @author kiska
	 * 
	 *         Returns true if addition of new borrowing was successful, else returns false
	 * 
	 * @param user
	 */
	boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil);
	public List<Borrow> getByUserId(String user_id);
}
