package com.management.crud.common.exception;

import com.management.crud.common.enums.ResponseCode;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    ResponseCode errorCode;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(ResponseCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ServiceException(ResponseCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
