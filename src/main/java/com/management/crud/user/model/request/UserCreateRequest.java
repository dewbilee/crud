package com.management.crud.user.model.request;

import com.management.crud.common.annotation.NoDuplicateElements;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateRequest {
    @NotBlank
    String name;

    @NotBlank
    String email;

    @NotBlank
    String password;

    @NotEmpty
    @NoDuplicateElements
    List<Integer> roleIds;
}
