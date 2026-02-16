package com.management.crud.role.controller;

import com.management.crud.common.response.GlobalResponse;
import com.management.crud.role.model.request.RoleCreateRequest;
import com.management.crud.role.model.request.RoleUpdateRequest;
import com.management.crud.role.service.RoleService;
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
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @GetMapping
    public GlobalResponse getRoles() {

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .data(service.readAll())
                .build();
    }

    @GetMapping("/{id}")
    public GlobalResponse getRolesById(@PathVariable("id") Long id) {

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .data(service.read(id))
                .build();
    }

    @PostMapping
    public GlobalResponse createRole(@Valid @RequestBody RoleCreateRequest request) {
        service.create(request);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }

    @PutMapping
    public GlobalResponse updateRole(@Valid @RequestBody RoleUpdateRequest request) {
        service.update(request);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }

    @DeleteMapping("/{id}")
    public GlobalResponse deleteRole(@PathVariable("id") Long id) {
        service.delete(id);

        return GlobalResponse.builder()
                .status(HttpStatus.OK.value())
                .message(SUCCESS.getValue())
                .build();
    }
}
