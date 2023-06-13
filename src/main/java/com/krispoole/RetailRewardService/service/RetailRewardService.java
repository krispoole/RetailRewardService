package com.krispoole.RetailRewardService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krispoole.RetailRewardService.entity.Rewards;
import com.krispoole.RetailRewardService.entity.Transaction;
import com.krispoole.RetailRewardService.repository.TransactionRepository;

@Service
public class RetailRewardService {

    @Autowired
    TransactionRepository transactionRepository;

    public Rewards calculateTotalRewards(Integer customerId) {

        Rewards rewards = new Rewards();

        List<Transaction> allTransactions = transactionRepository.findByCustomerId(customerId);

        Integer total = calculateRewards(allTransactions);

		rewards.setRetailRewards(total);
        rewards.setCustomerId(customerId);

		return rewards;
    }

    public Rewards calculateRewardsForMonth(Integer customerId, Integer month) {	

		Rewards rewards = new Rewards();

        List<Transaction> allTransactions = transactionRepository.findByCustomerIdAndMonth(customerId, month);
		
        Integer total = calculateRewards(allTransactions);

		rewards.setRetailRewards(total);
        rewards.setCustomerId(customerId);
        rewards.setMonth(month);

		return rewards;
	}

    public Integer calculateRewards(List<Transaction> transactions) {

        Integer total = 0;

        for (Transaction transaction : transactions) {

			Integer transactionAmount = transaction.getTransactionAmount().intValue();
			
			if (transactionAmount > 50 && transactionAmount < 100) {
				total += transactionAmount - 50;
			}
			
			if (transactionAmount >= 100) {
				total += 50 + (transactionAmount - 100) * 2;
			}
		}
            
        return total;
    }

}
