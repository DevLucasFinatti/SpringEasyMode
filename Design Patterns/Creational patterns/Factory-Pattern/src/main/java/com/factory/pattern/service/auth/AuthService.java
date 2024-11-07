package com.factory.pattern.service.auth;

import com.factory.pattern.entity.dto.auth.AccessDto;
import com.factory.pattern.entity.dto.auth.LoginDto;
import com.factory.pattern.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AccessDto login(LoginDto loginDto){
        if (loginDto.getEmail() == null || loginDto.getEmail().isEmpty() ||
                loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
            return new AccessDto("Missing value");
        }

        try {
            UsernamePasswordAuthenticationToken userAuth =
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                );

            Authentication authentication = authenticationManager.authenticate(userAuth);
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();
            String token = jwtUtils.generateToken(userAuthenticate);

            return new AccessDto(token);
        } catch (BadCredentialsException e) {
            return new AccessDto("Invalid Credentials");
        } catch (Exception e) {
            return new AccessDto("Access denied");
        }
    }
}
