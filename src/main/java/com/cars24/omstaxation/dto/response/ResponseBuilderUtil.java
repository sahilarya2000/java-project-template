package com.cars24.omstaxation.dto.response;

public class ResponseBuilderUtil {

	/**
	 * Success response with data.
	 *
	 * @param status  the status
	 * @param message the message
	 * @param data    the data
	 * @return resposneDTO object
	 */
	public static Response successResponseWithData(int status, String message, Object data) {
		return new SuccessResponse(status, message, data);
	}

	/**
	 * Success response.
	 *
	 * @param status  the status
	 * @param message the message
	 * @return the response
	 */
	public static Response successResponse(int status, String message) {
		return new SuccessResponse(status, message);
	}

	/**
	 * Error response.
	 *
	 * @param status  the status
	 * @param message the message
	 * @return the response
	 */
	public static Response errorResponse(int status, String message) {
		return new ErrorResponse(status, message);
	}

	/**
	 * Error response with debug message.
	 *
	 * @param status       the status
	 * @param message      the message
	 * @param debugMessage the debug message
	 * @return the response
	 */
	public static Response errorResponseWithDebugMessage(int status, String message, String debugMessage) {
		return new ErrorResponse(status, message, debugMessage);
	}

}
