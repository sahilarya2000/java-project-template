package com.cars24.omstaxation.exception;

/**
 * @author sauniksingh
 * Date: 10/09/19
 */
public class TaxConfigNotFoundException extends ItemNotFoundException {
    private static final long serialVersionUID = 1L;

    public TaxConfigNotFoundException(int status, String state, String message) {
        super(status, state, message);
    }
}
