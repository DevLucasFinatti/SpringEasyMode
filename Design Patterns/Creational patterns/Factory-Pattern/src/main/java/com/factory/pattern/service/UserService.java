package com.factory.pattern.service;

import com.factory.pattern.base.ApiResponse;
import com.factory.pattern.base.SystemMessages;
import com.factory.pattern.entity.User;
import com.factory.pattern.entity.dto.user.CreateUserDto;
import com.factory.pattern.entity.dto.user.UpdateUserDto;
import com.factory.pattern.entity.dto.user.UserResponseDto;
import com.factory.pattern.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {
        var user = new User();

        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));

        var response = userRepository.save(user);
        return response.getUserId();
    }

    public UserResponseDto getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            UserResponseDto userResponse = new UserResponseDto();
            userResponse.setUserId(user.get().getUserId());
            userResponse.setUsername(user.get().getUsername());
            userResponse.setEmail(user.get().getEmail());
            return userResponse;
        } else {
            throw new RuntimeException(SystemMessages.User.NOT_FOUND);
        }
    }

    public List<UserResponseDto> getAllUsers() {
        // Recupera todos os usuários do repositório
        List<User> users = userRepository.findAll();

        // Mapeia os usuários para a lista de UserResponseDto
        return users.stream()
                .map(user -> {
                    UserResponseDto userResponse = new UserResponseDto();
                    userResponse.setUserId(user.getUserId());
                    userResponse.setUsername(user.getUsername());
                    userResponse.setEmail(user.getEmail());
                    return userResponse;
                })
                .collect(Collectors.toList());
    }

    public ApiResponse updateUser(UpdateUserDto updateUserDto) {
        try {
            Optional<User> optionalUser = userRepository.findById(updateUserDto.getUserId());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                // Atualiza apenas os campos que não são nulos
                if (updateUserDto.getUsername() != null) {
                    user.setUsername(updateUserDto.getUsername());
                }
                if (updateUserDto.getEmail() != null) {
                    user.setEmail(updateUserDto.getEmail());
                }
                if (updateUserDto.getPassword() != null) {
                    user.setPassword(passwordEncoder.encode(updateUserDto.getPassword()));
                }

                userRepository.save(user); // Salva as alterações no repositório
                return new ApiResponse(user.getUserId(), SystemMessages.User.SUCCESS_UPDATED);
            } else {
                return new ApiResponse(updateUserDto, SystemMessages.User.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.User.FAIL_UPDATE);
        }
    }

    public ApiResponse deleteUser(String userId) {
        try {
            UUID id = UUID.fromString(userId);
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                userRepository.deleteById(id); // Deleta o usuário
                return new ApiResponse(id, SystemMessages.User.SUCCESS_DELETED);
            } else {
                return new ApiResponse(id, SystemMessages.User.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.User.FAIL_DELETE);
        }
    }
}
