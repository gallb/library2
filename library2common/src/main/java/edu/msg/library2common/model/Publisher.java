package edu.msg.library2common.model;

/**
 * represents publisher
 * 
 * @author nagys
 *
 */

public class Publisher extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	public Publisher(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
