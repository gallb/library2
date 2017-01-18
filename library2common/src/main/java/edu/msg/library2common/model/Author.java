package edu.msg.library2common.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * represents author
 * 
 * @author nagys
 *
 */
@Entity
@Table(name = "authors", catalog = "library2"
)
public class Author extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String uuid;
	
	public Author() {
	}
	
	public Author(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "uuid", unique = true, nullable = false)
	public String getUuid() {
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
