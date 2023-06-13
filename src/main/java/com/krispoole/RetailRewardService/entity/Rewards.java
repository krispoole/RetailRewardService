package com.krispoole.RetailRewardService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Rewards {

    @Id
    private Integer customerId;
    
    private int retailRewards;

    private Integer month;
    
}