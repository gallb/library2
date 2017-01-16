package edu.msg.library2common.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
/**
 * Every class of the model extends this class.
 * 
 * @author gallb
 * 
 */
public abstract class BaseEntity implements Serializable{
	private String uuid;

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
	
}
