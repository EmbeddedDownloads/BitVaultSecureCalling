package org.linphone.purchase;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class Purchasable {
	private String id, title, description, price;
	private long expire;
	private String purchasePayload, purchasePayloadSignature; 
	private String userData;
	
	public Purchasable(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Purchasable setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Purchasable setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getPrice() {
		return price;
	}

	public Purchasable setPrice(String price) {
		this.price = price;
		return this;
	}

	public long getExpire() {
		return expire;
	}
	
	public String getExpireDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
		Date date = new Date(expire);
		return dateFormat.format(date);
	}

	public Purchasable setExpire(long expire) {
		this.expire = expire;
		return this;
	}
	
	public Purchasable setPayloadAndSignature(String payload, String signature) {
		this.purchasePayload = payload;
		this.purchasePayloadSignature = signature;
		return this;
	}
	
	public String getPayload() {
		return this.purchasePayload;
	}
	
	public String getPayloadSignature() {
		return this.purchasePayloadSignature;
	}
	
	public Purchasable setUserData(String data) {
		this.userData = data;
		return this;
	}
	
	public String getUserData() {
		return this.userData;
	}
}
