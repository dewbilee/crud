package com.management.crud.common.enums;

import lombok.Getter;

@Getter
public enum Response {
    SUCCESS("Success");

    public final String value;

    Response(String value) {
        this.value = value;
    }
}
