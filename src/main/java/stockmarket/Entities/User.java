package main.java.stockmarket.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	private @Id @GeneratedValue Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String userType;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE})
	private Set<UserShare> userShare;
	
	public Set<UserShare> getUserShare() {
		return userShare;
	}

	public void setUserShare(Set<UserShare> userShare) {
		this.userShare = userShare;
	}

	public User(){}

	public User(String firstName, String lastName, String email, String userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = userType;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
