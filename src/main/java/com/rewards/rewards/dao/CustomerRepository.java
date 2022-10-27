package com.rewards.rewards.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rewards.rewards.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
