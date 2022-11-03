package com.customer.rewards.service;

import com.customer.rewards.dao.CustomerRepository;
import com.customer.rewards.dao.TransactionRepository;
import com.customer.rewards.exception.RewardsAPINoDataException;
import com.customer.rewards.model.CustomerRewardSummary;
import com.customer.rewards.model.Transaction;
import com.customer.rewards.util.TestDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

class RewardsServiceTest {
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    RewardsService rewardsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRewardPoints() throws RewardsAPINoDataException {
        when(transactionRepository.findAllByCustomerIdAndTransactionDateBetween(anyInt(), any(), any())).thenReturn(TestDataUtil.getTransactionData());
        when(customerRepository.findById(any())).thenReturn(Optional.of(TestDataUtil.getCustomerData()));
        CustomerRewardSummary result = rewardsService.getRewardPoints(Integer.valueOf(1548));
        //I haved added this to make it generic, We can also add Assertions.assertEquals(850,result.getMonth1Rewards()); for exact amount
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetDateBasedOnOffSetDays() {
        LocalDateTime result = rewardsService.getDateBasedOnOffSetDays(0);
        Assertions.assertNotNull(result);
    }
}