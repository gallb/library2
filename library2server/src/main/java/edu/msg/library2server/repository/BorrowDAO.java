package edu.msg.library2server.repository;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

public interface BorrowDAO extends DaoInterface{
	Borrow insertBorrow(User user, Publication pub);
}
