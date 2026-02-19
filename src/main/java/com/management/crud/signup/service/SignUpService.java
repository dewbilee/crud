package com.management.crud.signup.service;

import com.management.crud.signup.model.request.RegisterUserRequest;

public interface SignUpService {

    void create(RegisterUserRequest request);
}
