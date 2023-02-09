package com.company.service.impl;

import com.company.dto.RegistrationDto;
import com.company.entity.Authority;
import com.company.entity.UserEntity;
import com.company.exception.EmailAlreadyUsedException;
import com.company.exception.NotFoundException;
import com.company.repository.AuthorityRepository;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final AuthorityRepository authorityRepository;


    @Override
    public UserEntity findByName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()->new NotFoundException("Can't find user with given username"));
    }

    @Override
    @Transactional
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
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void register(RegistrationDto dto) {
        userRepository.findByUsername(dto.getUsername())
                .ifPresent(user -> {
                    throw new EmailAlreadyUsedException(dto.getUsername());
                });
        UserEntity user = createUserEntity(dto);
        userRepository.save(user);
    }


    private UserEntity createUserEntity(RegistrationDto dto) {
        UserEntity user = mapper.map(dto, UserEntity.class);
        Authority authority = Authority.builder()
                .authority("ROLE_USER")
                .build();
        authorityRepository.save(authority);
        Set<Authority> userAuthority = new HashSet<>();
        userAuthority.add(authority);
        user.setAuthorities(userAuthority);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setIpAddress(dto.getIpAddress());
        return user;
    }
}
