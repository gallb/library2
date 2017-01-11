package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

	public interface PublicationDao {
		List<Publication> getAllPublications();
		Publication getPublicationByName(String publication_name);
		User insertPublication(Publication pub);
		void updatePublication(Publication pub);
		void deletePublication(Publication pub);
	}


