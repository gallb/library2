package edu.msg.library2common.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
 

/**
 * represents publication
 * 
 * @author nagys
 *
 */
@Entity
@Table (name = "publications", catalog = "library2")
public class Publication extends BaseEntity  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	private String title;
	private Date date;
	@ManyToOne
    @JoinColumn(name = "publisher_id",
            foreignKey = @ForeignKey(name = "publisher_id"))
	private Publisher publisher;
	private int nrOfCopies;
	private int onStock;

	public Publication() {
		
	}
	
	public Publication(String title, Date date, Publisher publisher, int nrOfCopies, int onStock) {
		this.title = title;
		this.date = date;
		this.publisher = publisher;
		this.nrOfCopies = nrOfCopies;
		this.onStock = onStock;
	}
	
	@Override
	@Id
	@Column(name = "uuid", length = 45, unique = true, nullable = false)
	public String getUuid() {
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Column(name = "title", length = 45)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "publication_date", length = 10)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id", nullable = false)
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Column(name = "nr_of_copys")
	public int getNrOfCopies() {
		return nrOfCopies;
	}

	public void setNrOfCopies(int nrOfCopies) {
		this.nrOfCopies = nrOfCopies;
	}
	@Column(name = "on_stock")
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
