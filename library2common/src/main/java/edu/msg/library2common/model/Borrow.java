package edu.msg.library2common.model;

import java.sql.Date;


/**
 * Represents the borrowing of a book by a reader from the library
 * @author gallb
 *
 */
public class Borrow {
	private User reader;
	private Publication publication;
	private Date borrowFrom;
	private Date borrowUntil;
	
	public Borrow(User reader, Publication publication, Date borrowFrom, Date borrowUntil) {
		this.reader = reader;
		this.publication = publication;
		this.borrowFrom = borrowFrom;
		this.borrowUntil = borrowUntil;
	}

	public User getReader() {
		return reader;
	}

	public void setReader(User reader) {
		this.reader = reader;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Date getBorrowFrom() {
		return borrowFrom;
	}

	public void setBorrowFrom(Date borrowFrom) {
		this.borrowFrom = borrowFrom;
	}

	public Date getBorrowUntil() {
		return borrowUntil;
	}

	public void setBorrowUntil(Date borrowUntil) {
		this.borrowUntil = borrowUntil;
	}
}
