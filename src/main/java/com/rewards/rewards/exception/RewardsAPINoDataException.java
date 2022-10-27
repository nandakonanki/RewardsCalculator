package com.rewards.rewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "No Data Found for the Given Customer Id")
public class RewardsAPINoDataException extends RewardsAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5018385793764670677L;

	public RewardsAPINoDataException(String message, String code) {
		super(message, code);
	}

}
