package com.management.crud.permission.model.request;

import com.management.crud.common.annotation.NoDuplicateElements;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class PermissionCreateRequest {
    @NotBlank
    String name;

    @NotEmpty
    @NoDuplicateElements
    List<@NotBlank String> actions;

    @NotBlank
    String path;
}
