package main.java.stockmarket.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	private @Id @GeneratedValue Long userId;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String email;
	
	@JsonIgnore
	@NotEmpty
    private String password;
	
	@NotEmpty
	private String[] userRoles;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE})
	@JsonIgnore
	private Set<UserShare> userShare;
	
	public Set<UserShare> getUserShare() {
		return userShare;
	}

	public void setUserShare(Set<UserShare> userShare) {
		this.userShare = userShare;
	}

	public User(){}

	public User(String userName, String firstName, String lastName, String email, String password,
			String[] userRoles) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		setPassword(password);
		this.userRoles = userRoles;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = PASSWORD_ENCODER.encode(password);
	}

	public String[] getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String[] userRoles) {
		this.userRoles = userRoles;
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
