package com.management.crud.role.service.impl;

import com.management.crud.common.enums.ResponseCode;
import com.management.crud.common.exception.ServiceException;
import com.management.crud.permission.mapper.PermissionMapper;
import com.management.crud.permission.repository.PermissionRepository;
import com.management.crud.role.mapper.RoleMapper;
import com.management.crud.role.model.domain.Role;
import com.management.crud.role.model.entity.RoleEntity;
import com.management.crud.role.model.request.RoleCreateRequest;
import com.management.crud.role.model.request.RoleUpdateRequest;
import com.management.crud.role.model.response.RoleResponse;
import com.management.crud.role.repository.RoleRepository;
import com.management.crud.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    private final RoleMapper mapper;

    private final PermissionMapper permissionMapper;

    private final PermissionRepository permissionRepository;

    @Override
    public List<RoleResponse> readAll() {
        List<Role> roles = mapper.toDomain(repository.findByIsDeletedFalse());

        for (Role role : roles) {
            mapPermissions(role);
        }

        return mapper.toResponse(roles);
    }

    @Override
    public RoleResponse read(Long id) {
        checkExistence(id);
        Role role = mapper.toDomain(repository.findByIdAndIsDeletedFalse(id));
        mapPermissions(role);

        return mapper.toResponse(role);
    }

    @Override
    public void create(RoleCreateRequest request) {
        checkDuplicate(request.getName());
        checkPermissionIdsExistence(request.getPermissionIds());
        repository.save(mapper.toEntity(mapper.toDomain(request)));
    }

    @Override
    public void update(RoleUpdateRequest request) {
        checkExistence(request.getId());
        repository.save(mapper.toEntity(mapper.toDomain(request)));
    }

    @Override
    public void delete(Long id) {
        checkExistence(id);

        Role role = mapper.toDomain(repository.findByIdAndIsDeletedFalse(id));
        role.setDeleted(true);

        RoleEntity entity = mapper.toEntity(role);
        repository.save(entity);
    }

    private void checkPermissionIdsExistence(List<Integer> ids) {
        for (Integer id : ids) {
            checkExistence(Long.valueOf(id));
        }
    }

    private void checkDuplicate(String name) {
        if (repository.existsByNameAndIsDeletedFalse(name)) {
            throw new ServiceException(ResponseCode.ERR_4001, String.format("Permission not found name : %s", name));
        }
    }

    private void checkExistence(Long id) {
        boolean existence = repository.existsByIdAndIsDeletedFalse(id);

        if (!existence) {
            log.error(String.format("Permission not found id : %s", id));
            throw new ServiceException(ResponseCode.ERR_4005, String.format("Permission not found id : %s", id));
        }
    }

    private void mapPermissions(Role role) {
        List<Integer> permissions = role.getPermissionIds();
        Iterable<Long> iterableIds = permissions.stream()
                .map(Integer::longValue)
                .toList();

        role.setPermissions(permissionMapper.toDomain(permissionRepository.findAllById(iterableIds)));
    }

}
