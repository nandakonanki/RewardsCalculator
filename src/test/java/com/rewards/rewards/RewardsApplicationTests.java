package com.rewards.rewards;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rewards.rewards.exception.RewardsAPINoDataException;
import com.rewards.rewards.service.RewardsService;


class RewardsApplicationTests {

	@Autowired
	RewardsService rewardsService;
	
	@Test
	public void testGetRewardPoints() throws RewardsAPINoDataException {
		rewardsService.getRewardPoints(1);
	}

}
