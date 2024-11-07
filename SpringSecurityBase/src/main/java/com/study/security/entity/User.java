package com.study.security.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private UUID userId;

    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @CreationTimestamp
    private Instant dtCreated;

    @UpdateTimestamp
    private Instant dtUpdated;

    // Construtores

    public User() {
        this.userId = UUID.randomUUID();
    }

    public User(UUID userId, String username, String email, String password, Instant dtCreated, Instant dtUpdated) {
        super();
        this.userId = userId != null ? userId : UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = password;
        this.dtCreated = dtCreated;
        this.dtUpdated = dtUpdated;
    }

    // Getters & Setters

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Instant dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Instant getDtUpdated() {
        return dtUpdated;
    }

    public void setDtUpdated(Instant dtUpdated) {
        this.dtUpdated = dtUpdated;
    }
}
