package com.management.crud.user.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserUpdateRequest extends UserCreateRequest {
    @NotNull
    Long id;
}
