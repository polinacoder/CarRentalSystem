package com.code.system.business.exception;

public class NotFoundException extends BusinessException{
    public NotFoundException() {
        super("Запрашиваемый ресурс не найден");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
