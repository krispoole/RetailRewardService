package com.krispoole.RetailRewardService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krispoole.RetailRewardService.entity.Rewards;
import com.krispoole.RetailRewardService.entity.Transaction;
import com.krispoole.RetailRewardService.repository.TransactionRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class RetailRewardService {

    @Autowired
    TransactionRepository transactionRepository;

    public Rewards calculateTotalRewards(String email) {

        Rewards rewards = new Rewards();
        Double total = 0.00;

        List<Transaction> allTransactions = transactionRepository.findByCustomerEmail(email);

        for (Transaction transaction : allTransactions) {
		
			Integer transactionAmount = transaction.getTransactionAmount().intValue();
			
			if (transactionAmount > 50 && transactionAmount < 100) {
				total += transactionAmount - 50;
			}
			
			if (transactionAmount >= 100) {
				total += 50 + (transactionAmount - 100) * 2;
			}
		}

		rewards.setRetailRewards(total);

		return rewards;
    }

    public Rewards calculateRewardsForMonth(String email, int month) {	

		Rewards rewards = new Rewards();
		Double total = 0.00;

        List<Transaction> allTransactions = transactionRepository.findByCustomerEmail(email);
		
		for (Transaction transaction : allTransactions) {
			
			if (transaction.getTransactionDate().getMonthValue() == month) {
						
				Integer transactionAmount = transaction.getTransactionAmount().intValue();
				
				if (transactionAmount > 50 && transactionAmount < 100) {
					total += transactionAmount - 50;
				}
				
				if (transactionAmount >= 100) {
					total += 50 + (transactionAmount - 100) * 2;
				}
			}
		}

        rewards.setRetailRewards(total);
		
		return rewards;
	}

}
