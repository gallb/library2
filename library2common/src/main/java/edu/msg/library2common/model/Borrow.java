package edu.msg.library2common.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Represents the borrowing of a book by a reader from the library
 * @author gallb
 *
 */
@Entity
@Table(name = "borrows", catalog = "library2")
public class Borrow extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User reader;
	private Publication publication;
	private Date borrowFrom;
	private Date borrowUntil;
	private String uuid;
	
	public Borrow () {
	}
	
	public Borrow(User reader, Publication publication, Date borrowFrom, Date borrowUntil) {
		this.reader = reader;
		this.publication = publication;
		this.borrowFrom = borrowFrom;
		this.borrowUntil = borrowUntil;
	}

	@Id
	@Column(name = "uuid", unique = true, nullable = false)
	public String getUuid() {
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}
	
	/*@ManyToMany
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "user_id"))	*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public User getReader() {
		return reader;
	}

	public void setReader(User reader) {
		this.reader = reader;
	}
		
    /*@JoinColumn(name = "publication_id",
            foreignKey = @ForeignKey(name = "publication_id"))	*/	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publication_id", nullable = false)
	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	@Column(name = "borrow_from")
	public Date getBorrowFrom() {
		return borrowFrom;
	}

	public void setBorrowFrom(Date borrowFrom) {
		this.borrowFrom = borrowFrom;
	}

	@Column(name = "borrow_until")
	public Date getBorrowUntil() {
		return borrowUntil;
	}

	public void setBorrowUntil(Date borrowUntil) {
		this.borrowUntil = borrowUntil;
	}
}
