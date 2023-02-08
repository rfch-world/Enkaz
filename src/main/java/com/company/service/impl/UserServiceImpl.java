package com.company.service.impl;

import com.company.entity.UserEntity;
import com.company.exception.NotFoundException;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserEntity findByName(String username) {
        return userRepository.findByName(username)
                .orElseThrow(()->new NotFoundException("Can't find user with given username"));
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new NotFoundException("Can't find user with given id"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
