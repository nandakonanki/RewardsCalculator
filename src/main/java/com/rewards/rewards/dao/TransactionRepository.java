package com.rewards.rewards.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rewards.rewards.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	public List<Transaction> findAllByCustomerId(Integer customerID);

	public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Integer customerID, LocalDateTime from,
			LocalDateTime to);

}
