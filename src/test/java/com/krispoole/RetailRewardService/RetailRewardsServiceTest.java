package com.krispoole.RetailRewardService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krispoole.RetailRewardService.entity.Rewards;
import com.krispoole.RetailRewardService.service.RetailRewardService;

@SpringBootTest
public class RetailRewardsServiceTest {
    
    @Autowired
    private RetailRewardService retailRewardService;

    @Test
    public void calculateTotalRewardsTest() {

        Rewards rewards = retailRewardService.calculateTotalRewards(1);

        assertEquals(1, rewards.getCustomerId());
        assertEquals(2105, rewards.getRetailRewards());

    }

    @Test
    public void calculateRewardsForMonthTest() {
        
        Rewards rewards = retailRewardService.calculateRewardsForMonth(1, 1);

        assertEquals(1, rewards.getCustomerId());
        assertEquals(1, rewards.getMonth());
        assertEquals(5, rewards.getRetailRewards());
    }
}
