package com.management.crud.signup.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank
    String name;

    @NotBlank
    String email;

    @NotBlank
    String password;
}
