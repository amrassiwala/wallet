package com.saltside.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.saltside.wallet.model.Coupon;
import com.saltside.wallet.model.User;
import com.saltside.wallet.model.dao.CouponRepository;
import com.saltside.wallet.model.dao.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private CouponRepository couponRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, CouponRepository couponRepository) {
        this.userRepository = userRepository;
        this.couponRepository = couponRepository;
    }

    public void run(ApplicationArguments args) {
    	User u = new User();
    	u.setName("Admin");
    	u.setEmail("amrassiwala@gmail.com");
    	u.setType(1);
    	u.setKey("6182c7f8-4c51-4cb3-9dd3-367fd489844f");
        userRepository.save(u);
        
        
        Coupon c = new Coupon();
        c.setCode("WELCOME");
        c.setValue(20);
        c.setPromo_type(0);
        c.setFirst(true);
        c.setMin_amount(50);
        couponRepository.save(c);
        
        
        Coupon c1 = new Coupon();
        c1.setCode("SALTSIDE");
        c1.setValue(10);
        c1.setPromo_type(1);
        c1.setMax_discount(50);
        couponRepository.save(c1);
        
    }
}
