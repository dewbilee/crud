package com.management.crud.user.controller;

import com.management.crud.common.response.GlobalResponse;
import com.management.crud.user.model.request.UserCreateRequest;
import com.management.crud.user.model.request.UserUpdateRequest;
import com.management.crud.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.management.crud.common.enums.Response.SUCCESS;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public GlobalResponse getUsers() {

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .data(service.readAll())
                .build();
    }

    @GetMapping("/{id}")
    public GlobalResponse getUser(@PathVariable("id") Long id) {

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .data(service.read(id))
                .build();
    }

    @PostMapping
    public GlobalResponse createUser(@Valid @RequestBody UserCreateRequest request) {
        service.create(request);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }

    @PutMapping
    public GlobalResponse updateUser(@Valid @RequestBody UserUpdateRequest request) {
        service.update(request);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }

    @DeleteMapping("/{id}")
    public GlobalResponse deleteUser(@PathVariable("id") Long id) {
        service.delete(id);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }
}
