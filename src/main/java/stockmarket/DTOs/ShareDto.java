package main.java.stockmarket.DTOs;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import main.java.stockmarket.Entities.Share;
import main.java.stockmarket.Entities.User;
import main.java.stockmarket.Entities.UserShareKey;

public class ShareDto {

	private String shareCode;
	private String shareName;
	private String date;
	private double price;
	private int count;
	
	public ShareDto(String shareCode, String shareName, double price, int count, String date) {
		super();
		this.shareCode = shareCode;
		this.shareName = shareName;
		this.date = date;
		this.price = price;
		this.count = count;
	}
	
	public ShareDto() {}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}

