package com.management.crud.role.mapper;

import com.management.crud.role.model.domain.Role;
import com.management.crud.role.model.entity.RoleEntity;
import com.management.crud.role.model.request.RoleCreateRequest;
import com.management.crud.role.model.request.RoleUpdateRequest;
import com.management.crud.role.model.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleEntity toEntity(Role role);

    @Mapping(target = "permissions", ignore = true)
    Role toDomain(RoleEntity entity);

    List<Role> toDomain(List<RoleEntity> entity);

    RoleResponse toResponse(Role role);

    List<RoleResponse> toResponse(List<Role> role);

    Role toDomain(RoleCreateRequest request);

    Role toDomain(RoleUpdateRequest request);
}
