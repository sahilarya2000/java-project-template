package com.cars24.omstaxation.controller;

import com.cars24.omstaxation.constant.ApplicationConstants;
import com.cars24.omstaxation.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sauniksingh
 * Date: 10/09/19
 * * - All the rest controllers should be the sub classes of this class
 *  * - Shareable code among all controllers should be placed here
 */
@Slf4j
@RestController
public class BaseController {

    private static final String LOG_KEY_METHOD = "method:";
    private static final String LOG_KEY_API_ENDPOINT = " ,API endpoint:";

    @Autowired
    protected ObjectMapper objectMapper;

    @RequestScope
    protected HttpServletRequest getHttpRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    @RequestScope
    protected HttpServletResponse getHttpResponse() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected String createGetRequestInfo() {
        // method: API endpoint: /api/test?param=1&param=2,
        return CommonUtil.createString(LOG_KEY_METHOD, HttpMethod.GET, LOG_KEY_API_ENDPOINT,
                getHttpRequest().getRequestURI(), ApplicationConstants.QUERY_SYMBOL, getHttpRequest().getQueryString());
    }

    protected String toJson(Object object) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("[toJson] failed to parse object:{}", object);
        }
        return json;
    }
}
