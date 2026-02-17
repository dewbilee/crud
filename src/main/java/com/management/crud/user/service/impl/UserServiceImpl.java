package com.management.crud.user.service.impl;

import com.management.crud.common.enums.ResponseCode;
import com.management.crud.common.exception.ServiceException;

import com.management.crud.role.mapper.RoleMapper;
import com.management.crud.role.repository.RoleRepository;
import com.management.crud.user.mapper.UserMapper;
import com.management.crud.user.model.domain.User;
import com.management.crud.user.model.entity.UserEntity;
import com.management.crud.user.model.request.UserCreateRequest;
import com.management.crud.user.model.request.UserUpdateRequest;
import com.management.crud.user.model.response.UserResponse;
import com.management.crud.user.repository.UserRepository;
import com.management.crud.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    private final RoleMapper roleMapper;

    private final RoleRepository roleRepository;

    @Override
    public List<UserResponse> readAll() {
        List<User> users = mapper.toDomain(repository.findByIsDeletedFalse());

        for (User user : users) {
            mapRoles(user);
        }

        return mapper.toResponse(users);
    }

    @Override
    public UserResponse read(Long id) {
        checkExistence(id);
        User user = mapper.toDomain(repository.findByIdAndIsDeletedFalse(id));
        mapRoles(user);

        return mapper.toResponse(user);
    }

    @Override
    public void create(UserCreateRequest request) {
        checkDuplicate(request.getName());
        checkRoles(request.getRoleIds());
        repository.save(mapper.toEntity(mapper.toDomain(request)));
    }

    @Override
    public void update(UserUpdateRequest request) {
        checkExistence(request.getId());
        repository.save(mapper.toEntity(mapper.toDomain(request)));
    }

    @Override
    public void delete(Long id) {
        checkExistence(id);

        User user = mapper.toDomain(repository.findByIdAndIsDeletedFalse(id));
        user.setDeleted(true);

        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
    }

    private void checkDuplicate(String name) {
        if (repository.existsByEmailIgnoreCaseAndIsDeletedFalse(name)) {
            throw new ServiceException(ResponseCode.ERR_4001, String.format("User already exist : %s", name));
        }
    }

    private void checkExistence(Long id) {
        if (!repository.existsByIdAndIsDeletedFalse(id)) {
            log.error(String.format("User not found id : %s", id));
            throw new ServiceException(ResponseCode.ERR_4005, String.format("User not found id : %s", id));
        }
    }

    private void checkRoles(List<Integer> ids) {
        for (Integer id : ids) {
            checkRoleIdExistence(Long.valueOf(id));
        }
    }

    private void checkRoleIdExistence(Long id) {
        if (!roleRepository.existsByIdAndIsDeletedFalse(id)) {
            log.error(String.format("Role id not found : %s", id));
            throw new ServiceException(ResponseCode.ERR_4005, String.format("Role id not found : %s", id));
        }
    }

    private void mapRoles(User user) {
        List<Integer> roles = user.getRoleIds();
        Iterable<Long> iterableIds = roles.stream()
                .map(Integer::longValue)
                .toList();

        user.setRoles(roleMapper.toDomain(roleRepository.findAllById(iterableIds)));
    }
}
