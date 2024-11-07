package com.study.security.service;

import com.study.security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class UserDetailsImpl implements UserDetails {

    private UUID userId;

    private String username;

    private String email;

    private String password;

    public UserDetailsImpl(UUID userId, String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), new ArrayList<>());
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
