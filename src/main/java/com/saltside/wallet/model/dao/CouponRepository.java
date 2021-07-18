package com.saltside.wallet.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saltside.wallet.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer>{

	Coupon getByCode(String coupon);

}
