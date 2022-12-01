package com.expensetracker.app.model;

import java.util.Set;

public class User {

    private long userId;
    private String username;
    private String email;

    private Set<Category> category;

    public User() {
    }

    public User(long userId, String username) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.category = category;
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

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
