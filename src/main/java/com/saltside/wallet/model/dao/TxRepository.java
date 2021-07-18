package com.saltside.wallet.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saltside.wallet.model.Tx;
import com.saltside.wallet.model.User;

@Repository
public interface TxRepository extends JpaRepository<Tx, Integer>{

	List<Tx> findByUser(User user);

	@Query(value = "SELECT sum(amount) FROM Tx where user_id = ?1 and tx_type = ?2 and promo = ?3")
    public double getTotalBalance(int user_id, int type, boolean promo);

}
