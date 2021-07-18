package com.saltside.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.saltside.wallet.model.dao.CouponRepository;

@RestController
public class CouponController {

	@Autowired
	private CouponRepository repository;
	
	
}
