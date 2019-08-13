package main.java.stockmarket.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserShare {

	@EmbeddedId
	private UserShareKey userShareKey;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "userId")
	@JsonIgnore
	private User user;
	
	@ManyToOne
    @MapsId("shareCode")
    @JoinColumn(name = "shareCode")
	@JsonIgnore
	private Share share;
	
	private int count;
	
	
	public UserShare() {}

	public UserShare(UserShareKey userShareKey, User user, Share share, int count) {
		super();
		this.userShareKey = userShareKey;
		this.user = user;
		this.share = share;
		this.count = count;
	}

	public UserShareKey getUserShareKey() {
		return userShareKey;
	}

	public void setUserShareKey(UserShareKey userShareKey) {
		this.userShareKey = userShareKey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Share getShare() {
		return share;
	}

	public void setShare(Share share) {
		this.share = share;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	
}
