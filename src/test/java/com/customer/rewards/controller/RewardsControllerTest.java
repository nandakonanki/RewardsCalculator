package com.customer.rewards.controller;

import com.customer.rewards.dao.CustomerRepository;
import com.customer.rewards.exception.RewardsAPINoDataException;
import com.customer.rewards.model.APIResponse;
import com.customer.rewards.model.CustomerRewardSummary;
import com.customer.rewards.service.RewardsService;
import com.customer.rewards.util.TestDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;

class RewardsControllerTest {
    @Mock
    RewardsService rewardsService;
    @Mock
    Logger logger;
    @InjectMocks
    RewardsController rewardsController;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRewardPoints() throws RewardsAPINoDataException {
        when(rewardsService.getRewardPoints(anyInt())).thenReturn(new CustomerRewardSummary());
        when(customerRepository.findById(any())).thenReturn(Optional.of(TestDataUtil.getCustomerData()));
        ResponseEntity<APIResponse<CustomerRewardSummary>> result = rewardsController.getRewardPoints(Integer.valueOf(1));
        Assertions.assertNotNull(result);
    }
}