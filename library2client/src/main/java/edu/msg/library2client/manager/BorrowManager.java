package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;

public class BorrowManager implements RmiServiceManager<Borrow> {
	private BorrowServiceRmi borrowServiceRmi;
	private RmiRegistry rmiRegistry = new RmiRegistry();

	public BorrowManager() {
		borrowServiceRmi = rmiRegistry.getBorrowService();
	}

	@Override
	public List<Borrow> search(String searchString) throws ManagerException {
		List<Borrow> borrows = new ArrayList<>();
		try {
			borrows = borrowServiceRmi.getByUserId(searchString);
		} catch (ServiceException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.service.error"));
		} catch (RemoteException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.error"));
		}
		return borrows;
	}

	@Override
	public boolean addNewEntity(Borrow entity) throws ManagerException {
		System.out.println(entity.getReader().getUuid() + " " + entity.getPublication().getUuid());
		boolean flag = false;
		try {
			borrowServiceRmi.addNewEntity(entity);
			flag = true;
		} catch (ServiceException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.service.error"));
		} catch (RemoteException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.error"));
		}
		return flag;
	}

	@Override
	public boolean updateEntity(Borrow entity) throws ManagerException {
		boolean flag = false;
		try {
			borrowServiceRmi.updateEntity(entity);
			flag = true;
		} catch (ServiceException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.service.error"));
		} catch (RemoteException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.error"));
		}
		return flag;
	}

	@Override
	public boolean deleteEntity(String entityID) throws ManagerException {
		boolean flag = false;
		try {
			borrowServiceRmi.deleteEntity(entityID);
			flag = true;
		} catch (ServiceException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.service.error"));
		} catch (RemoteException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.error"));
		}
		return flag;
	}

}
