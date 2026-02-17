package com.management.crud.user.mapper;

import com.management.crud.user.model.domain.User;
import com.management.crud.user.model.entity.UserEntity;
import com.management.crud.user.model.request.UserCreateRequest;
import com.management.crud.user.model.request.UserUpdateRequest;
import com.management.crud.user.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(User user);

    @Mapping(target = "roles", ignore = true)
    User toDomain(UserEntity entity);

    List<User> toDomain(List<UserEntity> entity);

    UserResponse toResponse(User user);

    List<UserResponse> toResponse(List<User> user);

    User toDomain(UserCreateRequest request);

    User toDomain(UserUpdateRequest request);
}
