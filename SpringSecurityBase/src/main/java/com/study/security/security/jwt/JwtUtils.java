package com.study.security.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.study.security.service.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${JWT_SECRET}")
    private String jwtSecret;

    @Value("${JWT_EXPIRATION_TIME}")
    private int jwtExpirationTime;

    public String generateToken(UserDetailsImpl userDetail) {
        try {
            return Jwts.builder()
                    .setSubject(userDetail.getEmail()) // Define o username como subject
                    .setIssuedAt(new Date()) // Define a data de emissão
                    .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationTime)) // Define a expiração
                    .signWith(getSigninKey(), SignatureAlgorithm.HS512) // Assina o token com a chave e o algoritmo HMAC512
                    .compact(); // Gera o token compactado
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Key getSigninKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public String getUsernameByToken(String token) {
        // Extrai o subject do token, que contém o username
        String response = Jwts.parser()
                .setSigningKey(getSigninKey()) // Define a chave de assinatura para validar o token
                .build()
                .parseClaimsJws(token) // Faz o parsing e valida o token JWT
                .getBody() // Obtém o corpo do token (as claims)
                .getSubject(); // Obtém o subject, que é o username
        return response; // Retorna o username
    }


    public Boolean validateJwtToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getSigninKey()) // Define a chave de assinatura para validar o token
                    .build()
                    .parseClaimsJws(token); // Faz o parsing e valida o token JWT
            return true; // Se o token for válido
        } catch (Exception e) {
            System.out.println("Token inválido: " + e.getMessage());
            return false; // Token inválido ou expirado
        }
    }
}
