package com.management.crud.permission.mapper;

import com.management.crud.permission.model.domain.Permission;
import com.management.crud.permission.model.entity.PermissionEntity;
import com.management.crud.permission.model.request.PermissionCreateRequest;
import com.management.crud.permission.model.request.PermissionUpdateRequest;
import com.management.crud.permission.model.response.PermissionResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionEntity toEntity(Permission permission);

    Permission toDomain(PermissionEntity entity);

    List<Permission> toDomain(List<PermissionEntity> entity);

    PermissionResponse toResponse(Permission permission);

    List<PermissionResponse> toResponse(List<Permission> permission);

    Permission toDomain(PermissionCreateRequest request);

    Permission toDomain(PermissionUpdateRequest request);
}
