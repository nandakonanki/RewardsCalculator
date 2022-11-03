package com.customer.rewards.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.constants.RewardsAPIConstants;
import com.customer.rewards.dao.CustomerRepository;
import com.customer.rewards.dao.TransactionRepository;
import com.customer.rewards.exception.RewardsAPINoDataException;
import com.customer.rewards.model.Customer;
import com.customer.rewards.model.CustomerRewardSummary;
import com.customer.rewards.model.Transaction;


@Service
public class RewardsService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	CustomerRepository customerRepository;

	public CustomerRewardSummary getRewardPoints(Integer customerId) throws RewardsAPINoDataException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (!customer.isPresent()) {
			throw new RewardsAPINoDataException("User not found for the given Id : "+customerId, "99");
		}

		LocalDateTime lastMonthDate = getDateBasedOnOffSetDays(30);
		LocalDateTime lastSecondMonthDate = getDateBasedOnOffSetDays(60);
		LocalDateTime lastThirdMonthDate = getDateBasedOnOffSetDays(90);

		List<Transaction> lastMonthTransactions = transactionRepository
				.findAllByCustomerIdAndTransactionDateBetween(customerId, lastMonthDate, LocalDateTime.now());
		List<Transaction> lastSecondMonthTransactions = transactionRepository
				.findAllByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthDate, lastMonthDate);
		List<Transaction> lastThirdMonthTransactions = transactionRepository
				.findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthDate, lastSecondMonthDate);

		Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

		CustomerRewardSummary customerRewards = new CustomerRewardSummary();
		customerRewards.setCustomerId(customerId);
		customerRewards.setMonth1Rewards(lastMonthRewardPoints);
		customerRewards.setMonth2Rewards(lastSecondMonthRewardPoints);
		customerRewards.setMonth3Rewards(lastThirdMonthRewardPoints);
		customerRewards
				.setTotalRewardPoints(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;
	}

	private Long getRewardsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewards(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculateRewards(Transaction t) {
		if (t.getTransactionAmount() > RewardsAPIConstants.FIRST_LEVEL_REWARD
				&& t.getTransactionAmount() <= RewardsAPIConstants.SECOND_LEVEL_REWARD) {
			return Math.round(t.getTransactionAmount() - RewardsAPIConstants.FIRST_LEVEL_REWARD);
		} else if (t.getTransactionAmount() > RewardsAPIConstants.SECOND_LEVEL_REWARD) {
			return Math.round(t.getTransactionAmount() - RewardsAPIConstants.SECOND_LEVEL_REWARD) * 2
					+ (RewardsAPIConstants.SECOND_LEVEL_REWARD - RewardsAPIConstants.FIRST_LEVEL_REWARD);
		} else
			return 0l;

	}

	public LocalDateTime getDateBasedOnOffSetDays(int days) {
		return LocalDateTime.now().minusDays(days);
	}

}
