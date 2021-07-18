package com.saltside.wallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
	private String code;
	
	private boolean first=false;
	private float value;
	private int promo_type;
	private float min_amount;
	private float max_discount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public int getPromo_type() {
		return promo_type;
	}
	public void setPromo_type(int promo_type) {
		this.promo_type = promo_type;
	}
	public float getMin_amount() {
		return min_amount;
	}
	public void setMin_amount(float min_amount) {
		this.min_amount = min_amount;
	}
	public float getMax_discount() {
		return max_discount;
	}
	public void setMax_discount(float max_discount) {
		this.max_discount = max_discount;
	}
	
	

}
