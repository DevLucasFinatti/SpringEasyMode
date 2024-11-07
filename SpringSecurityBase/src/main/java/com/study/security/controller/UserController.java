package com.study.security.controller;

import com.study.security.base.ApiResponse;
import com.study.security.base.SystemMessages;
import com.study.security.entity.dto.CreateUserDto;
import com.study.security.entity.dto.UpdateUserDto;
import com.study.security.entity.dto.UserResponseDto;
import com.study.security.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ApiResponse createUser(@RequestBody CreateUserDto body) {
        // Verifica se os campos estão nulos
        if (body.email() == null || body.email().isEmpty() ||
                body.password() == null || body.password().isEmpty() ||
                body.username() == null || body.username().isEmpty()) {
            return new ApiResponse(body, SystemMessages.User.MISSING_VALUES);
        }

        try {
            var userId = userService.createUser(body);
            return new ApiResponse(userId, SystemMessages.User.SUCCESS_CREATED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.User.FAIL_CREATE);
        }
    }

    @GetMapping("/email/{userEmail}")
    public ApiResponse getUserByEmail(@PathVariable("userEmail") String userEmail) {
        // Verifica se os campos estão nulos
        if (userEmail == null || userEmail.isEmpty()) {
            return new ApiResponse(userEmail, SystemMessages.User.MISSING_VALUES);
        }
        try {
            UserResponseDto userResponse = userService.getUserByEmail(userEmail);
            return new ApiResponse(userResponse, SystemMessages.User.SUCCESS_GOT);
        } catch (Exception e) {
            return new ApiResponse(userEmail, SystemMessages.User.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ApiResponse getAllUsers() {
        try {
            // Recupera todos os usuários do repositório
            List<UserResponseDto> userResponseDtoList = userService.getAllUsers();
            if (userResponseDtoList.isEmpty()) {
                return new ApiResponse(userResponseDtoList, SystemMessages.User.NO_USERS);
            }
            return new ApiResponse(userResponseDtoList, SystemMessages.User.SUCCESS_GOT);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.User.GET_FAIL);
        }
    }

    @PutMapping("/update")
    public ApiResponse updateUser(@RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(updateUserDto);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(id);
    }
}
