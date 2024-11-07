package com.factory.pattern.entity.dto.auth;

public class AccessDto {

    private String Token;

    public AccessDto(String token) {
        Token = token;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
