package com.saltside.wallet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Tx> txs = new ArrayList<Tx>();
	
	@JsonIgnore
	@Column(name="key", columnDefinition = "VARCHAR(255)", updatable = false, nullable = false)
	private String key;
	
	private int type;
	
	@Transient
	private double balance;
	@Transient
	private double promotional_balance;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Tx> getTxs() {
		return txs;
	}

	public void setTxs(List<Tx> txs) {
		this.txs = txs;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPromotional_balance() {
		return promotional_balance;
	}

	public void setPromotional_balance(double promotional_balance) {
		this.promotional_balance = promotional_balance;
	}
	
}