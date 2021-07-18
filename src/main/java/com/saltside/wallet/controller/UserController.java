package com.saltside.wallet.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saltside.wallet.model.User;
import com.saltside.wallet.model.dao.TxRepository;
import com.saltside.wallet.model.dao.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TxRepository trepository;
	
	
	@PostMapping("/admin/adduser")
	public String saveUser(@RequestBody User user) {
		user.setKey(UUID.randomUUID().toString());
		repository.save(user);
		return "User added successfully, ID:"+ user.getId() +" API Key: "+user.getKey();
	}
	
	@GetMapping("/admin/getallusers")
	public List<User> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/getbalance/{id}")
	public User getBalanceForUser(@PathVariable Integer id){
		
		Optional<User> op = repository.findById(id);
		
		if(op.isPresent()) {
			User u = op.get();
			u.setBalance(getVal(u.getId(), 0, false) - getVal(u.getId(), 1, false));
			u.setPromotional_balance(getVal(u.getId(), 0, true) - getVal(u.getId(), 1, true));			
			return u;
		}else {
			return null;
		}

	}
	
	public double getVal(int userid, int type, boolean promo) {
		double val = 0;
		
		try {
			val = trepository.getTotalBalance(userid, type, promo);
		}catch(Exception e) {
			
		}
		
		return val;
	}
}