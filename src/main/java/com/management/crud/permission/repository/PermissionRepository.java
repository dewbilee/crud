package com.management.crud.permission.repository;

import com.management.crud.permission.model.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    List<PermissionEntity> findByIsDeletedFalse();

    PermissionEntity findByIdAndIsDeletedFalse(Long id);

    boolean existsByNameAndIsDeletedFalse(String name);

    boolean existsByIdAndIsDeletedFalse(Long id);

}
