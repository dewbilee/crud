package com.management.crud.user.model.entity;

import com.management.crud.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

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

    @ColumnDefault("false")
    @Column(name = "is_approved", nullable = false)
    boolean isApproved;

    @ColumnDefault("'system'")
    @Column(name = "approved_by")
    String approvedBy;

    @Column(name = "approver_ids", columnDefinition = "json", nullable = false)
    List<Integer> approverIds;
}
