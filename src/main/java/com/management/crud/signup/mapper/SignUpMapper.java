package com.management.crud.signup.mapper;

import com.management.crud.signup.model.request.RegisterUserRequest;
import com.management.crud.user.model.domain.User;
import com.management.crud.user.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SignUpMapper {
    User toDomain(RegisterUserRequest request);

    UserEntity toEntity(User user);
}
