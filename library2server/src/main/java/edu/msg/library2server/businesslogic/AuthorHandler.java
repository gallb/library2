package edu.msg.library2server.businesslogic;

import java.rmi.RemoteException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;
import edu.msg.library2server.business.AuthorHandlerInterface;
import edu.msg.library2server.business.BusinessLayerException;

/**
 * 
 * @author nagys
 *
 */
public class AuthorHandler implements AuthorHandlerInterface {

	@Override
	public boolean addNewEntity(Author entity) {
		
		return false;
	}

	@Override
	public boolean updateEntity(Author entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Author> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
