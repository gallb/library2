package edu.msg.library2common.model;

import java.sql.Date;

public class Newspaper extends Publication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Newspaper(String title, Date date, Publisher publisher, int nrOfCopies, int onStock) {
		super(title, date, publisher, nrOfCopies, onStock);
		// TODO Auto-generated constructor stub
	}

}
