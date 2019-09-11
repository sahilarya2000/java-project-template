package com.cars24.omstaxation.exception;

/**
 * @author sauniksingh
 * Date: 10/09/19
 */
public class SystemException extends RuntimeException {
    private String internalMessage;
    private int httpStatusCode;

    private SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(int httpStatusCode, String message) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public SystemException(String message, String internalMessage) {
        super(message);
        this.internalMessage = internalMessage;
    }

    public SystemException(int httpStatusCode, String message, String internalMessage) {
        super(message);
        this.internalMessage = internalMessage;
        this.httpStatusCode = httpStatusCode;
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(String message, Throwable cause, String internalMessage) {
        super(message, cause);
        this.internalMessage = internalMessage;
    }

    @Override
    public String toString() {
        return super.toString() + " internalMessage= " + internalMessage;
    }
}
