package com.company.auth.service.impl;

import com.company.auth.service.UserRegisterService;
import com.company.dto.UserDto;
import com.company.entity.UserEntity;
import com.company.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserServiceImpl userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserEntity registerNewUserAccount(UserDto userDto) throws Exception {
        String name=userDto.getName();
        String password=passwordEncoder.encode(userDto.getPassword());
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(name);
            userEntity.setPassword(password);
            return userService.save(userEntity);
    }
}
