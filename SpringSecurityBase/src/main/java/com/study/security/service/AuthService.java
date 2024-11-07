package com.study.security.service;

import com.study.security.entity.dto.AccessDto;
import com.study.security.entity.dto.LoginDto;
import com.study.security.security.jwt.JwtUtils;
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
        // Verifica se algum dos valores de login é nulo
        if (loginDto.getEmail() == null || loginDto.getEmail().isEmpty() ||
                loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
            return new AccessDto("Missing value");
        }

        try {
            // Cria um objeto padronizado para a autenticação pelo SpringSecurity (UsernamePasswordAuthenticationToken)
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()
                    );

            // Tenta autenticar o usuário
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Converte o usuário atual (getPrincipal()) autenticado pelo UserDetailsImpl em um UserDatails
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            // Cria o token JWT
            String token = jwtUtils.generateToken(userAuthenticate);

            return new AccessDto(token);
        } catch (BadCredentialsException e) {
            // Se as credenciais forem inválidas
            return new AccessDto("Invalid Credentials");
        } catch (Exception e) {
            // Se o usuário for negado
            return new AccessDto("Access denied");
        }
    }
}
