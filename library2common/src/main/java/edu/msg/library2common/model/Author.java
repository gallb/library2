package edu.msg.library2common.model;

/**
 * represents author
 * 
 * @author nagys
 *
 */

public class Author extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public Author(String name) {
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
