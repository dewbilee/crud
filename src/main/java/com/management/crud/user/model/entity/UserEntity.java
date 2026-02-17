package com.management.crud.user.model.entity;

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
@Table(name = "user")
public class UserEntity extends AccountEntity {

    @Column(name = "name", nullable = false)
    String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "role_ids", columnDefinition = "json", nullable = false)
    List<Integer> roleIds;
}
