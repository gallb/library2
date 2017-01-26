package edu.msg.library2server.businesslogic;

import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.business.UserHandlerInterface;

public class UserHandler implements UserHandlerInterface {

	@Override
	public boolean addNewEntity(User entity) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(User entity) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() throws BusinessLayerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchForUsers(String param) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(String id) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String user_name) throws BusinessLayerException {
		// TODO Auto-generated method stub
		return null;
	}



}
