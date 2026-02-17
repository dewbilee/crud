package com.management.crud.permission.service.impl;

import com.management.crud.common.enums.ResponseCode;
import com.management.crud.common.exception.ServiceException;
import com.management.crud.permission.mapper.PermissionMapper;
import com.management.crud.permission.model.domain.Permission;
import com.management.crud.permission.model.entity.PermissionEntity;
import com.management.crud.permission.model.request.PermissionCreateRequest;
import com.management.crud.permission.model.request.PermissionUpdateRequest;
import com.management.crud.permission.model.response.PermissionResponse;
import com.management.crud.permission.repository.PermissionRepository;
import com.management.crud.permission.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    private final PermissionMapper mapper;

    @Override
    public List<PermissionResponse> readAll() {
        return mapper.toResponse(mapper.toDomain(repository.findByIsDeletedFalse()));
    }

    @Override
    public PermissionResponse read(Long id) {
        checkExistence(id);
        PermissionEntity permissionEntity = repository.findByIdAndIsDeletedFalse(id);
        return mapper.toResponse(mapper.toDomain(permissionEntity));
    }

    @Override
    public void create(PermissionCreateRequest request) {
        checkDuplicate(request.getName());
        repository.save(mapper.toEntity(mapper.toDomain(request)));
    }

    @Override
    public void update(PermissionUpdateRequest request) {
        checkExistence(request.getId());
        repository.save(mapper.toEntity(mapper.toDomain(request)));
    }

    @Override
    public void delete(Long id) {
        checkExistence(id);

        Permission permission = mapper.toDomain(repository.findByIdAndIsDeletedFalse(id));
        permission.setDeleted(true);

        PermissionEntity entity = mapper.toEntity(permission);
        repository.save(entity);
    }

    private void checkDuplicate(String name) {
        if (repository.existsByNameAndIsDeletedFalse(name)) {
            throw new ServiceException(ResponseCode.ERR_4001, String.format("Permission already exist : %s", name));
        }
    }

    private void checkExistence(Long id) {
        if (!repository.existsByIdAndIsDeletedFalse(id)) {
            log.error(String.format("Permission not found id : %s", id));
            throw new ServiceException(ResponseCode.ERR_4005, String.format("Permission id not found : %s", id));
        }
    }
}
