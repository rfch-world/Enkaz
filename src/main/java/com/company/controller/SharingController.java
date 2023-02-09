package com.company.controller;

import com.company.dto.AccessTokenDto;
import com.company.dto.NumberOfAddressDto;
import com.company.service.SharingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sharing")
public class SharingController {
    private final SharingService sharingService;

    public SharingController(SharingService sharingService) {
        this.sharingService = sharingService;
    }

    @GetMapping("/topWreckList")
    public ResponseEntity<List<NumberOfAddressDto>> topWreckList() {
        return new ResponseEntity<>(this.sharingService.topWreckList(), HttpStatus.OK);
    }
}
