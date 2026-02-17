package com.management.crud.user.model.domain;

import com.management.crud.common.model.BaseDomain;
import com.management.crud.role.model.domain.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseDomain {
    String name;
    String email;
    String password;
    List<Integer> roleIds;
    List<Role> roles;
}
