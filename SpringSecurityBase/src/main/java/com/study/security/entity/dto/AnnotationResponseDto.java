package com.study.security.entity.dto;

public class AnnotationResponseDto {

    public String id;
    public String name;
    public String message;
    public String userId;

    public AnnotationResponseDto(String id, String name, String message, String userId) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.userId = userId;
    }

    public AnnotationResponseDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
