package com.management.crud.role.model.domain;

import com.management.crud.common.model.BaseDomain;
import com.management.crud.permission.model.domain.Permission;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;


import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends BaseDomain {
    String name;
    List<Integer> permissionIds;
    List<Permission> permissions;
}
