package com.management.crud.user.model.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.management.crud.common.response.BaseResponse;
import com.management.crud.role.model.response.RoleResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse extends BaseResponse {
    String name;
    String email;
    String password;
    List<RoleResponse> roles;
}
