package edu.msg.library2server.business;

import java.rmi.RemoteException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publisher;
import edu.msg.library2common.service.rmi.PublisherServiceRmi;
/**
 * 
 * @author nagyz
 *
 */
public class BasicPublisherBusiness implements PublisherServiceRmi {
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicPublisherBusiness.class);
	public BasicPublisherBusiness() throws BusinessLayerException{
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean addNewEntity(Publisher entity) throws  BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateEntity(Publisher entity) throws BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteEntity(String entityID) throws BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Publisher> serchByName(String name) throws BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
