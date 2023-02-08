package com.company.auth.service;

import com.company.dto.UserDto;
import com.company.entity.UserEntity;

public interface UserRegisterService {
    UserEntity registerNewUserAccount(UserDto userDto) throws Exception;
}
