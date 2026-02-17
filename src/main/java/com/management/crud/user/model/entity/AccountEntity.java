package com.management.crud.user.model.entity;

import com.management.crud.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public class AccountEntity extends BaseEntity {

    @Column(name = "email", unique = true, nullable = false)
    @Email
    String email;

    @Column(name = "password", nullable = false)
    String password;
}
