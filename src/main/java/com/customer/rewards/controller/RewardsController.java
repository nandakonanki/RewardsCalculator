package com.customer.rewards.controller;

import static com.customer.rewards.constants.RewardsAPIConstants.STATUS_FAILED;
import static com.customer.rewards.constants.RewardsAPIConstants.STATUS_SUCCESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.exception.RewardsAPINoDataException;
import com.customer.rewards.model.APIResponse;
import com.customer.rewards.model.CustomerRewardSummary;
import com.customer.rewards.model.Metadata;
import com.customer.rewards.service.RewardsService;

@RestController
public class RewardsController {

	@Autowired
	RewardsService rewardsService;

	private Logger logger = LoggerFactory.getLogger(RewardsController.class);

	@RequestMapping(value = "/customer/{customerId}/rewards", produces = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<APIResponse<CustomerRewardSummary>> getRewardPoints(@PathVariable Integer customerId) {
		APIResponse<CustomerRewardSummary> response = new APIResponse<>();
		Metadata metadata = new Metadata();
		logger.info("Getting reward points for CustomerID : {}", customerId);
		CustomerRewardSummary summary = null;
		try {
			summary = rewardsService.getRewardPoints(customerId);
			logger.info("Received reward points for CustomerID : {}", customerId);
			response.setData(summary);
			metadata.setStatus(STATUS_SUCCESS);
			metadata.setDescription("Success");
			response.setMetadata(metadata);
		} catch (RewardsAPINoDataException e) {
			metadata.setStatus(STATUS_FAILED);
			metadata.setDescription(e.getMessage());
			response.setMetadata(metadata);
		} catch (Exception e) {
			metadata.setStatus(STATUS_FAILED);
			metadata.setDescription(e.getMessage());
			response.setMetadata(metadata);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
