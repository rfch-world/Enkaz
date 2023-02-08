package com.company.auth.service;

import com.company.entity.UserEntity;
import com.company.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserServiceImpl userService;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        try {
            UserEntity userEntity = userService.findByName(name);
            User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(name);
            builder.disabled(false);
            builder.password(userEntity.getPassword());
            List<GrantedAuthority> authorityList = new ArrayList<>();
            builder.authorities(authorityList);
            return builder.build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("Kullanici adi ve ya parola yanlis.Hesabiniz yoksa lutfen kayit olun");
        }

    }
}
