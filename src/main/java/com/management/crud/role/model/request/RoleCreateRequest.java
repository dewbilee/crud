package com.management.crud.role.model.request;

import com.management.crud.common.annotation.NoDuplicateElements;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class RoleCreateRequest {
    @NotBlank
    String name;

    @NotEmpty
    @NoDuplicateElements
    List<Integer> permissionIds;
}
