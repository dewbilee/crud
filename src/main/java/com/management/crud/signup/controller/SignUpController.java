package com.management.crud.signup.controller;

import com.management.crud.common.response.GlobalResponse;
import com.management.crud.signup.model.request.RegisterUserRequest;
import com.management.crud.signup.service.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.management.crud.common.enums.Response.SUCCESS;

@RestController
@RequestMapping("/sign-up")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService service;

    @PostMapping
    public GlobalResponse createUser(@Valid @RequestBody RegisterUserRequest request) {
        service.create(request);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }
}
