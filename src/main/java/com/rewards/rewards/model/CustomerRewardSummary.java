package com.rewards.rewards.model;

public class CustomerRewardSummary {

	private Integer customerId;
	private Long month1Rewards;
	private Long month2Rewards;
	private Long month3Rewards;
	private Long totalRewardPoints;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Long getMonth1Rewards() {
		return month1Rewards;
	}

	public void setMonth1Rewards(Long month1Rewards) {
		this.month1Rewards = month1Rewards;
	}

	public Long getMonth2Rewards() {
		return month2Rewards;
	}

	public void setMonth2Rewards(Long month2Rewards) {
		this.month2Rewards = month2Rewards;
	}

	public Long getMonth3Rewards() {
		return month3Rewards;
	}

	public void setMonth3Rewards(Long month3Rewards) {
		this.month3Rewards = month3Rewards;
	}

	public Long getTotalRewardPoints() {
		return totalRewardPoints;
	}

	public void setTotalRewardPoints(Long totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

}
