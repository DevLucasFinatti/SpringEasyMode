package com.study.security.controller;

import com.study.security.base.ApiResponse;
import com.study.security.base.SystemMessages;
import com.study.security.entity.dto.AccessDto;
import com.study.security.entity.dto.LoginDto;
import com.study.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthControler {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ApiResponse login (@RequestBody LoginDto loginDto){
        AccessDto accessDto = authService.login(loginDto);

        if (Objects.equals(accessDto.getToken(), "Access denied")){
            return new ApiResponse(accessDto, SystemMessages.Auth.ACCESS_DENIED);
        } else if (Objects.equals(accessDto.getToken(), "Invalid Credentials")){
            return new ApiResponse(accessDto.getToken(), SystemMessages.Auth.INVALID_CREDENTIALS);
        } else if (Objects.equals(accessDto.getToken(), "Missing value")){
            return new ApiResponse(accessDto.getToken(), SystemMessages.Auth.MISSING_VALUES);
        }

        return new ApiResponse(accessDto, SystemMessages.Auth.SUCCESSFULLY_LOGIN);
    }
}
