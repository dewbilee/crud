package com.management.crud.role.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleUpdateRequest extends RoleCreateRequest {
    @NotNull
    Long id;
}
