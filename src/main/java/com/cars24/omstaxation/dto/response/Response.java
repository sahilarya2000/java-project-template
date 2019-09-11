package com.cars24.omstaxation.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Response {
	
	/** The message. */
	protected String message;
	
	/** The status. */
	protected int status;

}
