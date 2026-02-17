package com.management.crud.user.repository;

import com.management.crud.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByIsDeletedFalse();

    UserEntity findByIdAndIsDeletedFalse(Long id);

    boolean existsByEmailIgnoreCaseAndIsDeletedFalse(String email);

    boolean existsByIdAndIsDeletedFalse(Long id);
}
