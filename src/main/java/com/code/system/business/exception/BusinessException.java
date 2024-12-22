package com.code.system.business.exception;

public class BusinessException extends RuntimeException {
    public BusinessException() {
        super("Бизнес исключение");
    }

    public BusinessException(String message) {
        super(message);
    }
}
