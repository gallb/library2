package edu.msg.library2server.business;

import java.sql.Date;
import java.util.List;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

/**
 * 
 * @author kiska
 *
 */
public interface BorrowHandlerInterface extends BusinessInterface<Borrow> {
	/**
	 * 
	 * @param user
	 *            - a User object containing a user's information
	 * @param pub
	 *            - a Publication object containing a publication's information
	 * @param borrowFrom
	 *            - the date from which the user wants to borrow the publication
	 * @param borrowUntil
	 *            - the date on which the user needs to return the publication
	 * @return - true if insertion was successful, false otherwise
	 */
	boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil);

	/**
	 * queries all borrowing from the database
	 * 
	 * @return
	 */
	List<Borrow> getAll();

	/**
	 * 
	 * @param id
	 *            - the id of the borrowing to query
	 * @return - the borrow object obtained through search by id
	 */
	Borrow getById(String id);

	/**
	 * Checks whether the user has the right to borrow a publication
	 * 
	 * @param user_id
	 *            - the id of the user who wants to borrow
	 * @return - true if user is eligible for borrowing a publication, otherwise
	 *         false
	 */
	public boolean isLoyal(String user_id);

	/**
	 * Checks whether the desirable publication has any stock left
	 * 
	 * @param publication_id
	 *            - the id of the publication to check stock for
	 * @return - true if publication has at least 1 copy in stock, otherwise
	 *         false
	 */
	public boolean isOnStock(String publication_id);

	/**
	 * Checks whether a user has already three borrowings.
	 * 
	 * @param user_id
	 *            - the id of the user
	 * @return - true if the user has less than three borrowings, otherwise
	 *         false
	 */
	public boolean hasRightToBorrow(String user_id);

	/**
	 * 
	 * @param user_id
	 *            - the id of the user for which to check if has borrowing not
	 *            returned until due date
	 * @return - true if user is late with one or more publications, otherwise
	 *         returns false
	 */
	public boolean isLate(String user_id);
}
