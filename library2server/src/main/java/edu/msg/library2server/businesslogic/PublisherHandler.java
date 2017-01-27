package edu.msg.library2server.businesslogic;

import java.rmi.RemoteException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publisher;
import edu.msg.library2common.service.rmi.PublisherServiceRmi;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.business.PublisherHandlerInterface;
/**
 * 
 * @author nagyz
 *
 */
public class PublisherHandler implements PublisherHandlerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(PublisherHandler.class);

	
	@Override
	public boolean addNewEntity(Publisher entity) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Publisher entity) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
