package com.management.crud.common.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ResponseCode {
    ERR_2000(2000, "Success"),
    ERR_4000(4000, "Invalid parameter value."),
    ERR_4001(4000, "Data conflict."),
    ERR_4002(4001, "Unauthorized"),
    ERR_4003(4003, "Forbidden"),
    ERR_4004(4004, "Not found"),
    ERR_4005(4000, "Resource not found."),
    ERR_5000(5000, "System error on server side.");

    @Getter
    int httpCode;
    @Getter
    String message;

    ResponseCode(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;

    }
}
