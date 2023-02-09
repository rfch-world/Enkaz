package com.company.controller;

import com.company.auth.TokenProvider;
import com.company.dto.ResponseDto;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private UserService userService;
    private TokenProvider tokenProvider;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getUser(String token){
        try{
            String username = tokenProvider.getUsernameFromToken(token);
            UserEntity userEntity = userService.findByName(username);
            return ResponseEntity.ok(ResponseDto.builder()
                    .data(userEntity.getId().toString())
                    .httpStatus(HttpStatus.ACCEPTED)
                    .build());
        }catch (Exception e){
            return ResponseEntity.ok(ResponseDto.builder()
                    .data(e.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }
}
