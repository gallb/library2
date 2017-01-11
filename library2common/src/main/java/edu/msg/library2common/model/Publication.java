package edu.msg.library2common.model;

import java.sql.Date;

/**
 * represents publication
 * 
 * @author nagys
 *
 */

public class Publication extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private Date date;
	private Publisher publisher;
	private int nrOfCopies;
	private int onStock;

	public Publication(String title, Date date, Publisher publisher, int nrOfCopies, int onStock) {
		super();
		this.title = title;
		this.date = date;
		this.publisher = publisher;
		this.nrOfCopies = nrOfCopies;
		this.onStock = onStock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getNrOfCopies() {
		return nrOfCopies;
	}

	public void setNrOfCopies(int nrOfCopies) {
		this.nrOfCopies = nrOfCopies;
	}

	public int getOnStock() {
		return onStock;
	}

	public void setOnStock(int onStock) {
		this.onStock = onStock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
