package main.java.stockmarket.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserShareKey implements Serializable{

	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "shareCode")
	private String shareCode;
	
	@Column(name = "price")
	private Double price;

	public UserShareKey() {}
	
	public UserShareKey(Long userId, String shareCode, Double price) {
		super();
		this.userId = userId;
		this.shareCode = shareCode;
		this.price = price;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getShareCode() {
		return shareCode;
	}

	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((shareCode == null) ? 0 : shareCode.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserShareKey other = (UserShareKey) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shareCode == null) {
			if (other.shareCode != null)
				return false;
		} else if (!shareCode.equals(other.shareCode))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
}
