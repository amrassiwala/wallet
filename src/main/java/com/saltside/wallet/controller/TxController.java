package com.saltside.wallet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saltside.wallet.model.Coupon;
import com.saltside.wallet.model.Passbook;
import com.saltside.wallet.model.Tx;
import com.saltside.wallet.model.User;
import com.saltside.wallet.model.dao.CouponRepository;
import com.saltside.wallet.model.dao.TxRepository;
import com.saltside.wallet.model.dao.UserRepository;

@RestController
public class TxController {

	@Autowired
	private TxRepository repository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/add")
	public String saveTx(@RequestBody Tx tx) {
		float promo = 0f;
		String promocode = tx.getPromocode();
		if(tx!=null && promocode!=null && promocode!="") {
			Coupon c = couponRepository.getByCode(promocode);
			if(c.isFirst()) {
				List<Tx> txl = repository.findByUser(tx.getUser());
				if(txl == null || txl.size() == 0) {
					promo = applyPromocode(tx, c);
				}
			}else {
				promo = applyPromocode(tx, c);
			}
		}
		tx.setPromocode(null);
		repository.save(tx);
		
		if(promo > 0) {
			Tx tx1 = new Tx();
			tx1.setAmount(promo);
			tx1.setPromocode(promocode);
			tx1.setPromo(true);
			tx1.setDesc("Promocode applied for transaction id:"+tx.getId());
			tx1.setUser(tx.getUser());
			repository.save(tx1);
		}
		return "Transaction added successfully";
	}
	
	@PostMapping("/use")
	public String use(@RequestBody Tx tx) {
		tx.setTx_type(1);
		repository.save(tx);
		return "Transaction added successfully";
	}
	
	@GetMapping("/admin/getalltx")
	public List<Tx> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/passbook/{user}")
	public Passbook getTxForUser(@PathVariable User user){
		
		Passbook pb = new Passbook();
		pb.transactions = repository.findByUser(user);
		
		Optional<User> op = userRepository.findById(user.getId());
		
		if(op.isPresent()) {
			User u = op.get();
			u.setBalance(getVal(u.getId(), 0, false) - getVal(u.getId(), 1, false));
			u.setPromotional_balance(getVal(u.getId(), 0, true) - getVal(u.getId(), 1, true));			
			pb.user = u;
		}
		
		return pb;
	}
	
	public float applyPromocode(Tx tx, Coupon c) {
		
		float value = 0;
		
		if(c.getPromo_type()==0)
			value = c.getValue();
		else
			value = tx.getAmount() * c.getValue() / 100;
		
		
		if(c.getMax_discount() > 0) {
			if(value > c.getMax_discount())
				value = c.getMax_discount();
		}
		
		
		if(c.getMin_amount() > 0) {
			if(tx.getAmount() > c.getMin_amount()) {
				return value; 
			}else {
				return 0;
			}
		}
		
		return value;
		
	}
	
	public double getVal(int userid, int type, boolean promo) {
		double val = 0;
		
		try {
			val = repository.getTotalBalance(userid, type, promo);
		}catch(Exception e) {
			
		}
		
		return val;
	}
	
}
