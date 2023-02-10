package com.company.controller;

import com.company.auth.TokenProvider;
import com.company.dto.ResponseDto;
import com.company.dto.UserDto;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private UserService userService;
    private TokenProvider tokenProvider;

    @GetMapping("/get")
    public ResponseEntity<UserDto> getUser(@RequestHeader (name="Authorization") String token){
        try{
            String username = tokenProvider.getUsernameFromToken(token);
            UserEntity userEntity = userService.findByName(username);
            Long id = userEntity.getId();
            return ResponseEntity.status(HttpStatus.OK).body(UserDto.builder().id(id).name(username).build());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/ip")
    public ResponseEntity<ResponseDto> getIp(HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(ResponseDto.builder()
                .data(httpServletRequest.getRemoteAddr())
                .httpStatus(HttpStatus.ACCEPTED)
                .build());
    }
}
