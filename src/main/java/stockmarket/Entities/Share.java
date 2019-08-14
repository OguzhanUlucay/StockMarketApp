package main.java.stockmarket.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Share {

	private @Id String shareCode;
	private String shareName;
	
	@OneToMany(mappedBy = "share", cascade = {CascadeType.MERGE})
	@JsonIgnore
	private Set<UserShare> userShare;
	
	public Share() {}
	public Share(String shareCode, String shareName) {
		super();
		this.shareCode = shareCode;
		this.shareName = shareName;
	}
	public Set<UserShare> getUserShare() {
		return userShare;
	}
	public void setUserShare(Set<UserShare> userShare) {
		this.userShare = userShare;
	}
	public String getShareCode() {
		return shareCode;
	}
	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}
	public String getShareName() {
		return shareName;
	}
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	
}
