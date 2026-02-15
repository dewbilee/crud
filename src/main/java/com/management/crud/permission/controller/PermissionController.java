package com.management.crud.permission.controller;

import com.management.crud.common.response.GlobalResponse;
import com.management.crud.permission.model.request.PermissionCreateRequest;
import com.management.crud.permission.model.request.PermissionUpdateRequest;
import com.management.crud.permission.service.PermissionService;
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
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService service;

    @GetMapping
    public GlobalResponse getPermissions() {

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .data(service.readAll())
                .build();
    }

    @GetMapping("/{id}")
    public GlobalResponse getPermissionById(@PathVariable("id") Long id) {

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .data(service.read(id))
                .build();
    }

    @PostMapping
    public GlobalResponse createPermission(@Valid @RequestBody PermissionCreateRequest request) {
        service.create(request);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }

    @PutMapping
    public GlobalResponse updatePermission(@Valid @RequestBody PermissionUpdateRequest request) {
        service.update(request);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }

    @DeleteMapping("/{id}")
    public GlobalResponse deletePermission(@PathVariable("id") Long id) {
        service.delete(id);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }
}
