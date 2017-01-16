package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.Publication;

public interface PublicationDao extends DaoInterface {
	/**
	 * 
	 * @param publication_title  - the title of the publication
	 * @param pub_type - the type of the publication
	 * @return - a publication element
	 */
	 public List<Publication> searchPublications(String regularExpression);
}
