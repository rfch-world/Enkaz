package com.company.controller;

import com.company.auth.TokenProvider;
import com.company.dto.*;
import com.company.entity.SharingEntity;
import com.company.entity.UserEntity;
import com.company.service.SharingService;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sharing")
@RequiredArgsConstructor
public class SharingController {

    private final UserService userService;
    private final SharingService sharingService;
    private final TokenProvider tokenProvider;

    @GetMapping("/topWreckList")
    public ResponseEntity<List<NumberOfAddressDto>> topWreckList() {
        return new ResponseEntity<>(this.sharingService.topWreckList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long id){
        try{
            sharingService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPost(@RequestBody SharingDto sharingDto, @RequestHeader (name="Authorization") String token){
        try{
            String jwtToken = token.substring(7);
            String username = tokenProvider.getUsernameFromToken(jwtToken);
            UserEntity userEntity = userService.findByName(username);
            SharingEntity sharingEntity = new SharingEntity();
            sharingEntity.setAddress(sharingDto.getAddress());
            sharingEntity.setCity(sharingDto.getCity());
            sharingEntity.setPhoneNumber(sharingDto.getPhoneNumber());
            sharingEntity.setDistrict(sharingDto.getDistrict());
            sharingEntity.setNeighbourhood(sharingDto.getNeighbourhood());
            sharingEntity.setStreet(sharingDto.getStreet());
            sharingEntity.setInformationSource(sharingDto.getInformationSource());
            sharingEntity.setNameSurname(sharingDto.getNameSurname());
            sharingEntity.setUser(userEntity);
            sharingService.save(sharingEntity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sharings")
    public ResponseEntity<List<SharingResponseDto>> getAllSharing(){
        List<SharingEntity> sharingEntities = sharingService.findAll();
        List<SharingResponseDto> sharingDtos = new ArrayList<>();
        for(SharingEntity sharingEntity : sharingEntities){
            SharingResponseDto sharingDto = new SharingResponseDto();
            sharingDto.setId(sharingEntity.getId());
            sharingDto.setAddress(sharingEntity.getAddress());
            sharingDto.setCity(sharingEntity.getCity());
            sharingDto.setPhoneNumber(sharingEntity.getPhoneNumber());
            sharingDto.setDistrict(sharingEntity.getDistrict());
            sharingDto.setInformationSource(sharingEntity.getInformationSource());
            sharingDto.setNameSurname(sharingEntity.getNameSurname());
            sharingDto.setNeighbourhood(sharingEntity.getNeighbourhood());
            sharingDto.setStreet(sharingEntity.getStreet());
            sharingDto.setUserId(sharingEntity.getUser().getId().toString());
            sharingDtos.add(sharingDto);
        }
        return ResponseEntity.ok(sharingDtos);
    }
}
