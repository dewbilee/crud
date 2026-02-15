package com.management.crud.permission.service;

import com.management.crud.permission.model.request.PermissionCreateRequest;
import com.management.crud.permission.model.request.PermissionUpdateRequest;
import com.management.crud.permission.model.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    List<PermissionResponse> readAll();

    PermissionResponse read(Long id);

    void create(PermissionCreateRequest request);

    void update(PermissionUpdateRequest request);

    void delete(Long id);
}
