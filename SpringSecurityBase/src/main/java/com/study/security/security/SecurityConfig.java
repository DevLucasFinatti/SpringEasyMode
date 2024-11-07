package com.study.security.security;

import com.study.security.security.jwt.AuthFilterToken;
import com.study.security.security.jwt.AuthMiddlewareJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthMiddlewareJwt unauthorizedHandler;

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthFilterToken authFilterToken() {
        return new AuthFilterToken();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http.cors(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exeption -> exeption.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll()
                .requestMatchers("/users/**").permitAll()
                .anyRequest().authenticated());

        http.addFilterBefore(authFilterToken(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
