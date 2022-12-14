package com.expensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    private int categoryId;
    @NonNull
    private String name;
    @ManyToOne(cascade=CascadeType.PERSIST)         //many categories can be connected to one user
    private User user;                              //when we save the user, the category gets saved also

    public Category() {
    }

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
        this.user = user;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
