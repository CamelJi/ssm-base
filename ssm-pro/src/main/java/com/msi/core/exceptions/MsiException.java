package com.msi.core.exceptions;

/**
 * @author zyh
 * @Date 2020/12/30
 * @Description TODO
 */
public class MsiException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MsiException() {}

    public MsiException(String message) {
        super(message);
    }

    public MsiException(Throwable cause) {
        super(cause);
    }

    public MsiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
