package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceLayerException;

/**
 * Provides publication borrowing related services
/**
 * 
 * @author kiska
 *
 */

public interface BorrowServiceRmi  extends EntityServiceInterface<Borrow>{

	public static final String RMI_NAME = "Borrow";
	
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
	 * @throws ServiceLayerException 
	 * @throws RemoteException 
	 */
	boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil) throws RemoteException, ServiceLayerException;

	/**
	 * queries all borrowing from the database
	 * 
	 * @return
	 */
	List<Borrow> getAll();

	/**
	 * Returns a Borrow object that was searched for by an id
	 * @param id - the id of the borrowing to query
	 * @return - the borrow object obtained through search by id, if not found returns an empty borrow object
	 */
	Borrow getById(String id);

	/**
	 * Returns a Borrow object that was searched for by an user_id
	 * @param user_id - the id of the user whom borrowings we want to get
	 * @return - returns a list of borrowings if user is found, otherwise an empty list
	 */
	List<Borrow> getByUserId(String user_id);

}
