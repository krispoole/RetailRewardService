package com.krispoole.RetailRewardService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.krispoole.RetailRewardService.entity.Rewards;
import com.krispoole.RetailRewardService.service.RetailRewardService;

@CrossOrigin
@RestController
@RequestMapping("/api/customer/{customerId}/rewards")
public class RetailRewardsController {
    
    @Autowired
    RetailRewardService retailRewardService;

    @RequestMapping(value = "/total", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Rewards> retrieveTotalRewards(@PathVariable("customerId") Integer customerId){
		
		Rewards rewards = retailRewardService.calculateTotalRewards(customerId);
		
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}
	
    @RequestMapping(value = "/{month}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Rewards> retrieveRewardsByMonth(@PathVariable("customerId") Integer customerId, @PathVariable("month")Integer month){
		
		Rewards rewards = retailRewardService.calculateRewardsForMonth(customerId, month);
		
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}
    
}
