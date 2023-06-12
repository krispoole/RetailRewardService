package com.krispoole.RetailRewardService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.krispoole.RetailRewardService.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    
    @Query("SELECT T FROM Transaction T WHERE T.customer.email = ?1")
    List<Transaction> findByCustomerEmail(String email);

}