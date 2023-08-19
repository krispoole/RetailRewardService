package com.krispoole.RetailRewardService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krispoole.RetailRewardService.entity.Customer;
import com.krispoole.RetailRewardService.entity.Rewards;
import com.krispoole.RetailRewardService.entity.Transaction;
import com.krispoole.RetailRewardService.service.RetailRewardService;

@SpringBootTest
public class RetailRewardsServiceTest {
    
    @Autowired
    private RetailRewardService retailRewardService;

    @Test
    public void calculateTotalRewardsTest() {

        Rewards rewards = retailRewardService.calculateTotalRewards(1);

        assertEquals(1, rewards.getCustomerId());
        assertEquals(2105, 2105);

    }

    @Test
    public void calculateRewardsForMonthTest() {

        Rewards rewards = retailRewardService.calculateRewardsForMonth(1, 1);

        assertEquals(1, rewards.getCustomerId());
        assertEquals(1, rewards.getMonth());
        assertEquals(5, 5);
    }

    @Test
    public void calculateRewardsTest() {

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        Transaction transaction1 = new Transaction();
        Customer customer1 = new Customer();
        customer1.setCustomerId(1);

        transaction1.setCustomer(customer1);
        transaction1.setTransactionId(1);
        transaction1.setTransactionAmount(100.00);

        transactions.add(transaction1);

        assertEquals(50, retailRewardService.calculateRewards(transactions));
    }
}
