package com.customer.rewards.util;

import com.customer.rewards.model.Customer;
import com.customer.rewards.model.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public final class TestDataUtil {

    public static Customer getCustomerData(){
        Customer customer = new Customer();
        customer.setCustomerId(1548);
        customer.setCustomerName("Nanda");

        return customer;
    }

    public static List<Transaction> getTransactionData(){
        List<Transaction> returnList = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setTransactionId(100);
        transaction.setTransactionAmount(500.00);
        transaction.setCustomerId(1548);
        transaction.setTransactionDate(LocalDateTime.now());
        returnList.add(transaction);
        return returnList;
    }
}
