package com.management.crud.permission.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.management.crud.common.response.BaseResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionResponse extends BaseResponse {
    String name;
    List<String> actions;
    String path;
}
