package com.company.auth;

import com.company.entity.UserEntity;

public interface UserRegisterService {
    UserEntity registerNewUserAccount(UserDto userDto) throws Exception;
}
