package edu.msg.library2server.business;

import java.util.List;

import edu.msg.library2common.model.Author;

public interface AuthorHandlerInterface extends BusinessInterface<Author> {

	List<Author> getByName(String name);

}
