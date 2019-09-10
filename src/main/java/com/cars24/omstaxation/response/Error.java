package com.cars24.omstaxation.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**@author Saunik Singh*/
@Accessors(chain = true)
@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Error {
    private String field;
    private String message;
    private Object rejectedValue;

    public static Error createError(String message) {
        Error lmsError = new Error();
        lmsError.setMessage(message);
        return  lmsError;
    }
}
