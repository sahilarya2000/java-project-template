package com.cars24.omstaxation.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Saunik Singh
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoreResponse<T> {
    private String code;
    private String message;
    private T data;
    private List<Error> errors;
    private String requestId;

    public static <T> ResponseEntity<CoreResponse<T>> buildWithSuccess(ResponseCode responseCode, T data) {
        // Constructing response with success status and details
        CoreResponse<T> lmsResponseEntity = new CoreResponse<>();
        lmsResponseEntity.setCode(responseCode.getCode());
        lmsResponseEntity.setMessage(responseCode.getMessage());
        lmsResponseEntity.setData(data);
        return ResponseEntity.status(responseCode.getHttpStatus()).body(lmsResponseEntity);
    }

    public static ResponseEntity<CoreResponse<Object>> buildWithErrors(
            ResponseCode responseCode, List<Error> errors) {
        // Constructing response with errors provided and data is left as null
        CoreResponse<Object> lmsResponseEntity = new CoreResponse<>();
        lmsResponseEntity.setCode(responseCode.getCode());
        lmsResponseEntity.setMessage(responseCode.getMessage());
        lmsResponseEntity.setErrors(errors);
        return ResponseEntity.status(responseCode.getHttpStatus()).body(lmsResponseEntity);
    }

    public static ResponseEntity<CoreResponse<Object>> buildWithFailure(ResponseCode responseCode) {
        // Constructing response with errors provided and data is left as null
        CoreResponse<Object> lmsResponseEntity = new CoreResponse<>();
        lmsResponseEntity.setCode(responseCode.getCode());
        lmsResponseEntity.setMessage(responseCode.getMessage());
        return ResponseEntity.status(responseCode.getHttpStatus()).body(lmsResponseEntity);
    }

    /**
     * Note: For backward compatibility of API error contract with c2c-lms-web
     * message will be sent in errors as also.
     *
     * @param httpStatus
     * @param message
     * @return
     */
    public static ResponseEntity<Object> buildWithHttpStatusAndMessage(HttpStatus httpStatus, String message) {
        CoreResponse<Object> coreResponse = new CoreResponse<>();
        coreResponse.setCode(httpStatus.toString());
        coreResponse.setMessage(message);
        List<Error> errorList = new ArrayList<>();
        errorList.add(Error.createError(message));
        coreResponse.setErrors(errorList);
        return ResponseEntity.status(httpStatus).body(coreResponse);
    }

    public static <T> ResponseEntity<CoreResponse<T>> buildWithHttpStatusAndData(HttpStatus httpStatus, T data) {
        // Constructing response with http status and data
        CoreResponse<T> lmsResponseEntity = new CoreResponse<>();
        lmsResponseEntity.setData(data);
        return ResponseEntity.status(httpStatus).body(lmsResponseEntity);
    }

    public static <T> ResponseEntity<CoreResponse<T>> buildWithHttpStatusAndDataAndMessage(HttpStatus httpStatus,
                                                                                           T data, String message) {
        // Constructing response with http status and data
        CoreResponse<T> lmsResponseEntity = new CoreResponse<>();
        lmsResponseEntity.setData(data);
        lmsResponseEntity.setMessage(message);
        return ResponseEntity.status(httpStatus).body(lmsResponseEntity);
    }

    public static ResponseEntity<Object> buildWithMessageAndErrors(HttpStatus httpStatus, String errorMsg,
                                                                   List<Error> lmsErrorList) {
        // Constructing response with errors provided and data is left as null
        CoreResponse<Object> lmsResponseEntity = new CoreResponse<>();
        lmsResponseEntity.setCode(httpStatus.toString());
        lmsResponseEntity.setMessage(errorMsg);
        lmsResponseEntity.setErrors(lmsErrorList);
        return ResponseEntity.status(httpStatus).body(lmsResponseEntity);
    }
}
