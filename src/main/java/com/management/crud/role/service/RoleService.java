package com.management.crud.role.service;

import com.management.crud.role.model.request.RoleCreateRequest;
import com.management.crud.role.model.request.RoleUpdateRequest;
import com.management.crud.role.model.response.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> readAll();

    RoleResponse read(Long id);

    void create(RoleCreateRequest request);

    void update(RoleUpdateRequest request);

    void delete(Long id);
}
