package com.company.controller;

import com.company.auth.UserDetailsService;
import com.company.auth.UserDto;
import com.company.auth.UserRegisterService;
import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    public String showMainPage(){
        return "index.html";
    }

    @PostMapping("check-authentication")
    public ResponseEntity<ResponseDto> check(Principal principal){
        if (principal==null){
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("")
                    .httpStatus(HttpStatus.UNAUTHORIZED)
                    .build());
        }
        return ResponseEntity.ok(ResponseDto.builder()
                .message("")
                .httpStatus(HttpStatus.ACCEPTED)
                .build());
    }
    @PostMapping("register")
    public ResponseEntity<ResponseDto> registerUser(@Valid @RequestBody UserDto userDto){
        try{
            if (userRepository.findByName(userDto.getName()).isPresent()){
                throw new Exception("Bu isimli kullanici zaten mevcut");
            }
            userRegisterService.registerNewUserAccount(userDto);
            userDetailsService.loadUserByUsername(userDto.getName());
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("Kayit basarili.Lutfen giris yapin !")
                    .httpStatus(HttpStatus.ACCEPTED)
                    .build());
        }
        catch (Exception e){
            return ResponseEntity.ok(ResponseDto.builder()
                    .message(e.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }
}
