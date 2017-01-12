package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.Publication;

public interface PublicationDao {
	List<Publication> getAllPublications();
	Publication getPublicationByTitle(String publication_title);
	Publication getPublicationByTitleAndType(String publication_title,Publication pub_type);		
	Publication insertPublication(Publication pub);
	void updatePublication(Publication pub);
	void deletePublication(Publication pub);
}



