package com.factory.pattern.controller;

import com.factory.pattern.base.ApiResponse;
import com.factory.pattern.base.SystemMessages;
import com.factory.pattern.entity.dto.auth.AccessDto;
import com.factory.pattern.entity.dto.auth.LoginDto;
import com.factory.pattern.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

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
