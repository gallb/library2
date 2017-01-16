package edu.msg.library2common.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

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
	private String uuid;

	public User(String name, String userName, int loyalityIndex, String password, UserType userType) {
		this.name = name;
		this.userName = userName;
		this.loyalityIndex = loyalityIndex;
		this.password = password;
		this.userType = userType;
	}

	public User() {
	}
	
	@Override
	@Id
	@ManyToMany
    @JoinColumn(name = "uuid",
            foreignKey = @ForeignKey(name = "user_id"))	
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

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "loyalty_index")
	public int getLoyalityIndex() {
		return loyalityIndex;
	}

	public void setLoyalityIndex(int loyalityIndex) {
		this.loyalityIndex = loyalityIndex;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_type")
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
