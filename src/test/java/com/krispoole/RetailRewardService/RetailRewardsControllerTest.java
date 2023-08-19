package com.krispoole.RetailRewardService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.krispoole.RetailRewardService.controller.RetailRewardsController;
import com.krispoole.RetailRewardService.entity.Rewards;
import com.krispoole.RetailRewardService.service.RetailRewardService;

@SpringBootTest

public class RetailRewardsControllerTest {
    
    @Autowired
    private RetailRewardsController retailRewardsController;

    @MockBean
    private RetailRewardService retailRewardService;

    @Test
    public void testRetrieveTotalRewards() throws Exception {
        Rewards rewards = new Rewards();
        rewards.setCustomerId(1);
        rewards.setRetailRewards(100);

        when(retailRewardService.calculateTotalRewards(1)).thenReturn(rewards);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        ResponseEntity<Rewards> responseEntity = retailRewardsController.retrieveTotalRewards(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().getCustomerId());
        assertEquals(100, responseEntity.getBody().getRetailRewards());
    }

    // I'm just testing commit stuff
    
    @Test
    public void testRetrieveRewardsByMonth() {
        Rewards rewards = new Rewards();
        rewards.setCustomerId(1);
        rewards.setRetailRewards(100);
        rewards.setMonth(1);

        when(retailRewardService.calculateRewardsForMonth(rewards.getCustomerId(), rewards.getMonth())).thenReturn(rewards);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        ResponseEntity<Rewards> responseEntity = retailRewardsController.retrieveRewardsByMonth(rewards.getCustomerId(), rewards.getMonth());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().getCustomerId());
        assertEquals(100, responseEntity.getBody().getRetailRewards());
    }
}
