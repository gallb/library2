package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publisher;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.service.rmi.PublisherServiceRmi;
/**
 * 
 * @author nagyz
 *
 */
public class BasicPublisherService extends UnicastRemoteObject implements PublisherServiceRmi {
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicPublisherService.class);

	protected BasicPublisherService() throws ServiceException,RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addNewEntity(Publisher entity) throws ServiceException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Publisher entity) throws ServiceException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws ServiceException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Publisher> serchByName(String name) throws ServiceException,RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
