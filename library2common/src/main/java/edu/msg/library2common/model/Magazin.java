package edu.msg.library2common.model;

import java.sql.Date;
import java.util.List;

public class Magazin extends Publication {

	private static final long serialVersionUID = 1L;
	private List<Author> authors;

	public Magazin(String title, Date date, Publisher publisher, int nrOfCopies, int onStock) {
		super(title, date, publisher, nrOfCopies, onStock);
		// TODO Auto-generated constructor stub
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
