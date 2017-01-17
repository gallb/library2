package edu.msg.library2server.repository;

import java.sql.Date;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

public interface BorrowDAO extends DaoInterface{
	boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil);
}
