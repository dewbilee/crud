package com.management.crud.user.service;

import com.management.crud.user.model.request.UserCreateRequest;
import com.management.crud.user.model.request.UserUpdateRequest;
import com.management.crud.user.model.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> readAll();

    UserResponse read(Long id);

    void create(UserCreateRequest request);

    void update(UserUpdateRequest request);

    void delete(Long id);
}
