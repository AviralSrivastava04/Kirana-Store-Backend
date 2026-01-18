package com.example.kirana.store.controller;

import com.example.kirana.store.dto.inputDto.UserInputDto;
import com.example.kirana.store.dto.outputDto.UserOutputDto;
import com.example.kirana.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserInputDto userInputDto){
        return ResponseEntity.ok(userService.register(userInputDto));
    }
}
