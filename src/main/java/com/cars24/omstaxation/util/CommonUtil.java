package com.cars24.omstaxation.util;

import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * @author sauniksingh
 * Date: 10/09/19
 */
public class CommonUtil {
    /**
     * It can be used to create long string from multiple parameters
     *
     * @param objects
     * @return
     */
    public static String createString(Object... objects) {
        String resultStr = null;
        if (!ObjectUtils.isEmpty(objects)) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(objects).forEach(object -> {
                sb.append(object);
            });
            resultStr = sb.toString();
        }
        return resultStr;
    }
}
