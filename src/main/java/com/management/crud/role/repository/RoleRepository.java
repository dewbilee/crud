package com.management.crud.role.repository;

import com.management.crud.role.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    List<RoleEntity> findByIsDeletedFalse();

    RoleEntity findByIdAndIsDeletedFalse(Long id);

    boolean existsByNameAndIsDeletedFalse(String name);

    boolean existsByIdAndIsDeletedFalse(Long id);

}
