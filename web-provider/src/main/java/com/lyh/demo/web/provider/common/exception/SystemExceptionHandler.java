package com.lyh.demo.web.provider.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luoyihang
 * @date 2019/5/6 14:21
 */
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {

    /**
     * 系统异常
     *
     * @param e 异常
     * @return map
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, String> systemHandler(Exception e) {
        log.error("系统异常", e);
        Map<String, String> result = new HashMap<>(4);
        result.put("statusCode", "500");
        result.put("statusMessage", "系统异常");
        return result;
    }

    /**
     * 业务异常
     *
     * @param e 异常
     * @return map
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Map<String, String> bizHandler(BaseException e) {
        log.error("", e);
        Map<String, String> result = new HashMap<>(4);
        result.put("statusCode", e.getType());
        result.put("statusMessage", e.getDetail());
        return result;
    }

    /**
     * 校验异常
     *
     * @param e 异常
     * @return map
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Map<String, String> checkHandler(BaseException e) {
        log.error("", e);
        Map<String, String> result = new HashMap<>(4);
        result.put("statusCode", "202");
        result.put("statusMessage", e.getDetail());
        return result;
    }
}
