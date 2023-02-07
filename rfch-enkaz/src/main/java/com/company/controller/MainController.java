package com.company.controller;

import com.company.auth.UserDetailsService;
import com.company.auth.UserDto;
import com.company.auth.UserRegisterService;
import com.company.entity.SharingEntity;
import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import com.company.service.SharingService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private SharingService sharingService;
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    public String showMainPage(){
        return "index.html";
    }

    @GetMapping("get-sharing")
    public ResponseEntity<List<SharingResponseDto>> getAllSharing(){
        List<SharingEntity> sharingEntities = sharingService.findAll();
        List<SharingResponseDto> sharingDtos = new ArrayList<>();
        for(SharingEntity sharingEntity : sharingEntities){
            SharingResponseDto sharingDto = new SharingResponseDto();
            sharingDto.setId(sharingEntity.getId());
            sharingDto.setAddress(sharingEntity.getAddress());
            sharingDto.setPersonality(sharingEntity.getPersonality());
            sharingDto.setSummary(sharingEntity.getSummary());
            sharingDto.setUserId(sharingEntity.getUser().getId().toString());
            sharingDtos.add(sharingDto);
        }
        return ResponseEntity.ok(sharingDtos);
    }
    @GetMapping("get-user")
    public ResponseEntity<ResponseDto> getUser(Principal principal){
        try{
            UserEntity userEntity = userService.findByName(principal.getName());
            return ResponseEntity.ok(ResponseDto.builder()
                    .message(userEntity.getId().toString())
                    .httpStatus(HttpStatus.ACCEPTED)
                    .build());
        }catch (Exception e){
            return ResponseEntity.ok(ResponseDto.builder()
                    .message(e.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }

    @PostMapping("delete")
    public ResponseEntity<ResponseDto> deletePost(@RequestBody Long id){
        try{
            sharingService.deleteById(id);
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("Post basariyla silindi !")
                    .httpStatus(HttpStatus.ACCEPTED)
                    .build());
        }
        catch (Exception e){
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("Post silinirken hata olustu.")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }

    @PostMapping("addPost")
    public ResponseEntity<ResponseDto> addPost(@RequestBody SharingDto sharingDto){
        try{
            UserEntity userEntity = userService.findById(new Long(sharingDto.getUserId()));
            SharingEntity sharingEntity = new SharingEntity();
            sharingEntity.setAddress(sharingDto.getAddress());
            sharingEntity.setPersonality(sharingDto.getPersonality());
            sharingEntity.setSummary(sharingDto.getSummary());
            sharingEntity.setUser(userEntity);
            sharingService.save(sharingEntity);
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("Post basariyla paylasildi !")
                    .httpStatus(HttpStatus.ACCEPTED)
                    .build());
        }
        catch (Exception e){
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("Post paylasilirken hata olustu.")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build());
        }
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
