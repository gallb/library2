package edu.msg.library2common.model;

/**
 * represents user
 * 
 * @author nagys
 *
 */

public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String userName;
	private int loyalityIndex;
	private String password;
	private UserType userType;

	public User(String name, String userName, int loyalityIndex, String password, UserType userType) {
		super();
		this.name = name;
		this.userName = userName;
		this.loyalityIndex = loyalityIndex;
		this.password = password;
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLoyalityIndex() {
		return loyalityIndex;
	}

	public void setLoyalityIndex(int loyalityIndex) {
		this.loyalityIndex = loyalityIndex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
