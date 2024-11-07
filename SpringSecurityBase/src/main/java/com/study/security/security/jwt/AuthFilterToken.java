package com.study.security.security.jwt;

import com.study.security.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthFilterToken extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getToken(request);

            if (jwtUtil.validateJwtToken(jwt)) {
                String userName = jwtUtil.getUsernameByToken(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken (HttpServletRequest request){
        String headerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer")){
            return headerToken.replace("Bearer ", "");
        }
        return headerToken;
    }
}
