package com.study.security.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "annotation")
public class Annotation {

    @Id
    @GeneratedValue
    private UUID annotationId;

    private String name;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructor
    public Annotation() {
        this.annotationId = UUID.randomUUID();
    }

    public Annotation(UUID id, String name, String message, User user) {
        this.annotationId = id;
        this.name = name;
        this.message = message;
        this.user = user;
    }

    // Getters and Setters
    public UUID getAnnotationId() {
        return annotationId;
    }

    public void setAnnotationId(UUID annotationId) {
        this.annotationId = annotationId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
