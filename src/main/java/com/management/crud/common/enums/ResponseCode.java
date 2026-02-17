package com.management.crud.common.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ResponseCode {
    ERR_2000(200, "ERR_2000", "Success"),
    ERR_4000(400, "ERR_4000", "Invalid parameter value."),
    ERR_4001(400, "ERR_4001", "Data conflict."),
    ERR_4002(401, "ERR_4002", "Unauthorized"),
    ERR_4003(403, "ERR_4003", "Forbidden"),
    ERR_4004(404, "ERR_4004", "Not found"),
    ERR_4005(400, "ERR_4004", "Resource not found."),
    ERR_5000(500, "ERR_5000", "System error on server side.");

    @Getter
    int httpCode;
    @Getter
    String message;
    @Getter
    String description;

    ResponseCode(int httpCode, String message, String description) {
        this.httpCode = httpCode;
        this.message = message;
        this.description = description;
    }
}
