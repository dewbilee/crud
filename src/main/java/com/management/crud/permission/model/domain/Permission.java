package com.management.crud.permission.model.domain;

import com.management.crud.common.model.BaseDomain;
import com.management.crud.common.enums.Methods;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission extends BaseDomain {
    String name;
    List<Methods> actions;
    String path;
}
