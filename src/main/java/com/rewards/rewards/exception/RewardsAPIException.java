package com.rewards.rewards.exception;

public class RewardsAPIException extends Exception {

	private static final long serialVersionUID = 6062547740939964702L;
	private String code = null;
	private String message = "";

	public RewardsAPIException(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
