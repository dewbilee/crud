package com.management.crud.signup.service.impl;

import com.management.crud.common.enums.ResponseCode;
import com.management.crud.common.exception.ServiceException;
import com.management.crud.signup.mapper.SignUpMapper;
import com.management.crud.signup.model.request.RegisterUserRequest;
import com.management.crud.signup.service.SignUpService;
import com.management.crud.user.model.domain.User;
import com.management.crud.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository repository;

    private final SignUpMapper mapper;


    @Override
    public void create(RegisterUserRequest request) {
        checkDuplicate(request.getName());

        User user = mapper.toDomain(request);
        user.setRoleIds(new ArrayList<>());
        user.setApproverIds(List.of(1, 2, 3));

        repository.save(mapper.toEntity(user));
    }

    private void checkDuplicate(String name) {
        if (repository.existsByEmailIgnoreCaseAndIsDeletedFalse(name)) {
            throw new ServiceException(ResponseCode.ERR_4001, String.format("User already exist : %s", name));
        }
    }

}
