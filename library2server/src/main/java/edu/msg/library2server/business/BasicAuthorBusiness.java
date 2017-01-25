package edu.msg.library2server.business;

import java.rmi.RemoteException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;

public class BasicAuthorBusiness implements AuthorServiceRmi {
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicAuthorBusiness.class);

	@Override
	public boolean addNewEntity(Author entity) throws BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Author entity) throws BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Author> serchByName(String name) throws BusinessLayerException,RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
