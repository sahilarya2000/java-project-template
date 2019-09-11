package com.cars24.omstaxation.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ErrorResponse.
 * 
 * @author Shubhanshu
 */
@Getter
@JsonInclude(value = Include.NON_NULL)
@ToString
public class ErrorResponse extends Response {

	/** The debug message. */
	private String debugMessage;

	/**
	 * Instantiates a new error response.
	 *
	 * @param status the status
	 * @param message the message
	 * @param debugMessage the debug message
	 */
	public ErrorResponse(int status, String message, String debugMessage) {
		this.status = status;
		this.message = message;
		this.debugMessage = debugMessage;
	}

	/**
	 * Instantiates a new error response.
	 *
	 * @param errorMessage the error message
	 */
	public ErrorResponse(String errorMessage) {
		this.debugMessage = errorMessage;
	}

	/**
	 * Instantiates a new error response.
	 *
	 * @param status the status
	 * @param message the message
	 */
	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	/* (non-Javadoc)
	 * @see com.cars24.dms.beans.response.core.CoreResponse#getMessage()
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

	/* (non-Javadoc)
	 * @see com.cars24.dms.beans.response.core.CoreResponse#getStatus()
	 */
	@Override
	public int getStatus() {
		return this.status;
	}
	
}
