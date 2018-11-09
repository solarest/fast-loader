package com.solarest.fastloader.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller基类
 *
 * @author jinjian
 */
@RestControllerAdvice
public abstract class BaseController {

    private static final String CODE = "response_code";
    private static final String MSG = "message";
    private static final String RESULT = "result";
    private static final String SUCCESS_CODE = "00";
    private static final String DEFAULT_CODE = "03";
    private static final String SUCCESS_MSG = "操作成功";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseController() {
    }

    /**
     * 拦截异常
     *
     * @param e 异常
     * @return 异常响应json
     */
    @ExceptionHandler()
    public String exception(Exception e) {
        JSONObject json = new JSONObject();
        json.put(CODE, DEFAULT_CODE);
        json.put(MSG, e.getMessage());

        if (e instanceof JSONException) {
            json.put(MSG, "JSON解析格式异常");
        } else if (e instanceof NullPointerException) {
            json.put(MSG, "数据字段缺失");
        } else {
            json.put(MSG, e.getMessage());
        }
        logger.warn("请求出现异常", e);
        return json.toString();
    }

    String response(Object o) {
        JSONObject json = new JSONObject();
        json.put(CODE, SUCCESS_CODE);
        json.put(MSG, SUCCESS_MSG);
        json.put(RESULT, o);
        return json.toString();
    }

    String responseIncludeNull(Object o) {
        JSONObject json = new JSONObject();
        json.put(CODE, SUCCESS_CODE);
        json.put(MSG, SUCCESS_MSG);
        json.put(RESULT, o);
        return JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue);
    }

    String responseSuccess() {
        JSONObject json = new JSONObject();
        json.put(CODE, SUCCESS_CODE);
        json.put(MSG, SUCCESS_MSG);
        return json.toString();
    }
}
