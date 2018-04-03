package com.jimmie.test.jackson;/**
 * Created by jimmie on 2018/4/3.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author jimmie
 * @create 2018-04-03 下午2:00
 */

public class JacksonUtils {



    private static final ObjectMapper str2ObjectMapper = new ObjectMapper();

    private static final ObjectMapper nullObjectMapper = new ObjectMapper();

    private static final ObjectMapper nonNullObjectMapper = new ObjectMapper();

    static {
        str2ObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        nullObjectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        nonNullObjectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        nonNullObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> T json2Object(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            T object = str2ObjectMapper.readValue(json, clazz);
            return object;
        } catch (IOException e) {
            return null;
        }

    }

    public static String object2Json(Object object, boolean containNull) {
        if (object == null) {
            return "";
        }
        try {
            if (!containNull) {
                return nonNullObjectMapper.writeValueAsString(object);
            }
            return nullObjectMapper.writeValueAsString(object);
        } catch (IOException e) {
            return "";
        }
    }

    public static Map json2Map(String json, boolean containNull) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            if (!containNull) {
                return nonNullObjectMapper.readValue(json, Map.class);
            }
            return nullObjectMapper.readValue(json, Map.class);
        } catch (IOException e) {
            return null;
        }
    }

    private JacksonUtils() {
    }
}
