package com.lyh.demo.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author luoyihang
 * @date 2019/5/6 14:19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends Exception {
    private String type;

    private String detail;

    public BaseException() {
    }

    public BaseException(String type, String message) {
        super(message);
        this.type = type;
        this.detail = message;
    }

    public BaseException(String type, String message, String detail) {
        super(message);
        this.type = type;
        this.detail = detail;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
