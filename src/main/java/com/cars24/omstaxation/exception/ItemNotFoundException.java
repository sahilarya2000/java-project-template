package com.cars24.omstaxation.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sauniksingh
 * Date: 10/09/19
 */
@Getter
@Setter
public class ItemNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    private int status;
    private String itemId;

    public ItemNotFoundException(int status, String itemId, String message) {
        super(message);
        this.itemId = itemId;
        this.status = status;
    }
}
