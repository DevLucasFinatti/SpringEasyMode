package com.study.security.entity.dto;

import java.util.UUID;

public class AnnotationDto {

    public String name;
    public String message;
    public String userId;

    public AnnotationDto(String name, String message, String userId) {
        this.name = name;
        this.message = message;
        this.userId = userId;
    }

    public AnnotationDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
