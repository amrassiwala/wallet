package com.saltside.wallet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tx {
	
	@Id
	@GeneratedValue
	private int id;
	private float amount;
	private boolean promo;
	

	@ManyToOne(targetEntity =  User.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	private int tx_type;
	private long timestamp;
	private String desc;
	private String promocode;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getTx_type() {
		return tx_type;
	}
	public void setTx_type(int tx_type) {
		this.tx_type = tx_type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isPromo() {
		return promo;
	}
	public void setPromo(boolean promo) {
		this.promo = promo;
	}
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	
	
	
	
}
