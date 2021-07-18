package com.saltside.wallet.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saltside.wallet.model.Tx;
import com.saltside.wallet.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
