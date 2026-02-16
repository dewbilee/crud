package com.management.crud.role.model.entity;

import com.management.crud.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Setter
@Getter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "role")
public class RoleEntity extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "permission_ids", columnDefinition = "json", nullable = false)
    List<Integer> permissionIds;
}
