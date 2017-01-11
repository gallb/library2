package edu.msg.library2common.model;

import java.io.Serializable;
import java.util.UUID;
/**
 * Every class of the model extends this class.
 * 
 * @author gallb
 * 
 */
public abstract class BaseEntity implements Serializable{
	private String uuid;

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
