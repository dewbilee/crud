package com.management.crud.permission.service.impl;

import com.management.crud.common.exception.ServiceException;
import com.management.crud.permission.mapper.PermissionMapper;
import com.management.crud.permission.model.domain.Permission;
import com.management.crud.permission.model.entity.PermissionEntity;
import com.management.crud.permission.model.request.PermissionCreateRequest;
import com.management.crud.permission.model.request.PermissionUpdateRequest;
import com.management.crud.permission.model.response.PermissionResponse;
import com.management.crud.permission.repository.PermissionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class PermissionServiceImplTest {

    @Mock
    private PermissionRepository repository;

    @Mock
    private PermissionMapper mapper;

    @InjectMocks
    private PermissionServiceImpl service;

    private PermissionEntity entity;
    private Permission domain;
    private PermissionResponse response;

    @BeforeEach
    void setUp() {
        entity = new PermissionEntity();
        entity.setId(1L);

        domain = new Permission();
        domain.setId(1L);

        response = new PermissionResponse();
        response.setId(1L);
    }

    @Test
    void readAll_success() {
        Mockito.when(repository.findByIsDeletedFalse()).thenReturn(List.of(entity));
        Mockito.when(mapper.toDomain(List.of(entity))).thenReturn(List.of(domain));
        Mockito.when(mapper.toResponse(List.of(domain))).thenReturn(List.of(response));

        List<PermissionResponse> result = service.readAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());

        Mockito.verify(repository).findByIsDeletedFalse();
        Mockito.verify(mapper).toDomain(List.of(entity));
        Mockito.verify(mapper).toResponse(List.of(domain));
    }

    @Test
    void read_success() {
        Long id = 1L;

        Mockito.when(repository.existsByIdAndIsDeletedFalse(id)).thenReturn(true);
        Mockito.when(repository.findByIdAndIsDeletedFalse(id)).thenReturn(entity);
        Mockito.when(mapper.toDomain(entity)).thenReturn(domain);
        Mockito.when(mapper.toResponse(domain)).thenReturn(response);

        PermissionResponse result = service.read(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());

        Mockito.verify(repository).existsByIdAndIsDeletedFalse(id);
        Mockito.verify(repository).findByIdAndIsDeletedFalse(id);
    }

    @Test
    void read_notFound_shouldThrowException() {
        Long id = 1L;

        Mockito.when(repository.existsByIdAndIsDeletedFalse(id)).thenReturn(false);

        Assertions.assertThrows(ServiceException.class, () -> service.read(id));

        Mockito.verify(repository).existsByIdAndIsDeletedFalse(id);
        Mockito.verify(repository, Mockito.never()).findByIdAndIsDeletedFalse(Mockito.any());
    }

    @Test
    void create_success() {
        PermissionCreateRequest request = new PermissionCreateRequest();
        request.setName("READ");

        Mockito.when(repository.existsByNameAndIsDeletedFalse("READ")).thenReturn(false);
        Mockito.when(mapper.toDomain(request)).thenReturn(domain);
        Mockito.when(mapper.toEntity(domain)).thenReturn(entity);

        service.create(request);

        Mockito.verify(repository).existsByNameAndIsDeletedFalse("READ");
        Mockito.verify(repository).save(entity);
    }

    @Test
    void create_duplicate_shouldThrowException() {
        PermissionCreateRequest request = new PermissionCreateRequest();
        request.setName("READ");

        Mockito.when(repository.existsByNameAndIsDeletedFalse("READ")).thenReturn(true);

        Assertions.assertThrows(ServiceException.class, () -> service.create(request));

        Mockito.verify(repository).existsByNameAndIsDeletedFalse("READ");
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void update_success() {
        PermissionUpdateRequest request = new PermissionUpdateRequest();
        request.setId(1L);

        Mockito.when(repository.existsByIdAndIsDeletedFalse(1L)).thenReturn(true);
        Mockito.when(mapper.toDomain(request)).thenReturn(domain);
        Mockito.when(mapper.toEntity(domain)).thenReturn(entity);

        service.update(request);

        Mockito.verify(repository).existsByIdAndIsDeletedFalse(1L);
        Mockito.verify(repository).save(entity);
    }

    @Test
    void update_notFound_shouldThrowException() {
        PermissionUpdateRequest request = new PermissionUpdateRequest();
        request.setId(1L);

        Mockito.when(repository.existsByIdAndIsDeletedFalse(1L)).thenReturn(false);

        Assertions.assertThrows(ServiceException.class, () -> service.update(request));

        Mockito.verify(repository).existsByIdAndIsDeletedFalse(1L);
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void delete_success() {
        Long id = 1L;

        Mockito.when(repository.existsByIdAndIsDeletedFalse(id)).thenReturn(true);
        Mockito.when(repository.findByIdAndIsDeletedFalse(id)).thenReturn(entity);
        Mockito.when(mapper.toDomain(entity)).thenReturn(domain);
        Mockito.when(mapper.toEntity(domain)).thenReturn(entity);

        service.delete(id);

        Assertions.assertTrue(domain.isDeleted());

        Mockito.verify(repository).existsByIdAndIsDeletedFalse(id);
        Mockito.verify(repository).findByIdAndIsDeletedFalse(id);
        Mockito.verify(repository).save(entity);
    }

    @Test
    void delete_notFound_shouldThrowException() {
        Long id = 1L;

        Mockito.when(repository.existsByIdAndIsDeletedFalse(id)).thenReturn(false);

        Assertions.assertThrows(ServiceException.class, () -> service.delete(id));

        Mockito.verify(repository).existsByIdAndIsDeletedFalse(id);
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }
}