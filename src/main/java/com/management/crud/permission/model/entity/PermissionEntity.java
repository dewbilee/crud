package com.management.crud.permission.model.entity;

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
@Table(name = "permission")
public class PermissionEntity extends BaseEntity {

    @Column(name = "name", unique = true)
    String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    List<String> actions;

    @Column(name = "path")
    String path;
}
