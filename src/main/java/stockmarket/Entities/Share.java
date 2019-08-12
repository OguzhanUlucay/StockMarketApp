package main.java.stockmarket.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Share {

	private @Id String shareCode;
	private String shareName;
	
	public Share() {}
	public Share(String shareCode, String shareName) {
		super();
		this.shareCode = shareCode;
		this.shareName = shareName;
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
