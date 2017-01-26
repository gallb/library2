package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;

public class BorrowManager implements RmiServiceManager<Borrow>{
	private BorrowServiceRmi borrowServiceRmi;
	private RmiRegistry rmiRegistry = new RmiRegistry();
	
	public BorrowManager() {
		borrowServiceRmi = rmiRegistry.getBorrowService();
	}

	@Override
	public List<Borrow> search(String searchString){
		return borrowServiceRmi.getByUserId(searchString);
	}

	@Override
	public boolean addNewEntity(Borrow entity) throws ManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Borrow entity) throws ManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws ManagerException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
