package com.krispoole.RetailRewardService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.krispoole.RetailRewardService.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT C FROM Customer C WHERE C.customerId = ?1")
    Customer findByCustomerId(Integer customerId);
    
}