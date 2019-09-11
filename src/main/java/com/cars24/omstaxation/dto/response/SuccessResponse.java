package com.cars24.omstaxation.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class SuccessResponse.
 * 
 * @author shailendra
 */
@Getter
@JsonInclude(value=Include.NON_NULL)
@NoArgsConstructor
@ToString
public class SuccessResponse extends Response {
	
	/** The data. */
	private Object data;
	
	/**
	 * Instantiates a new success response.
	 *
	 * @param status the status
	 * @param message the message
	 * @param data the data
	 */
	public SuccessResponse(int status,String message,Object data) {
		this.data = data;
		this.status = status;
		this.message = message;
	}
	
	/**
	 * Instantiates a new success response.
	 *
	 * @param status the status
	 * @param message the message
	 */
	public SuccessResponse(int status,String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * Instantiates a new success response.
	 *
	 * @param data the data
	 */
	public SuccessResponse(Object data) {
		this.data = data;
	}

	/**
	 * Instantiates a new success response.
	 *
	 * @param data the data
	 */
	public SuccessResponse(Object data,String message) {
		this.data = data;
		this.message = message;
	}
	
}
