package edu.msg.library2server.repository.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publisher;
import edu.msg.library2server.repository.PublisherDAO;

public class HibernatePublisherDao implements PublisherDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernatePublisherDao.class);
	
	public HibernatePublisherDao() {
		
	}

	@Override
	public List<Publisher> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publisher> getByName(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Publisher e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Publisher e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Publisher getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
