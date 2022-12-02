package com.expensetracker.app.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long userId;
    private String username;
    private String email;


    public User() {
    }

    public User(long userId, String username) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username=" + username +
                ", email=" + email+'\'' +
                '}';
    }
}
