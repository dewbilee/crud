package com.management.crud.permission.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionUpdateRequest extends PermissionCreateRequest {
    @NotNull
    Long id;
}
