package edu.msg.library2common.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * represents publisher
 * 
 * @author nagys
 *
 */

@Entity
@Table (name = "publishers", catalog = "library2")

public class Publisher extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String uuid;

	public Publisher() {
	}
	
	public Publisher(String name) {
		this.name = name;
	}
	
	@Override
	@Id
	//@OneToMany(mappedBy = "publishers")
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

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
