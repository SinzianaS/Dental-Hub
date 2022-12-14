package com.expensetracker.app.model;

import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    private int id;
    @NonNull
    private String name;
    @ManyToOne(cascade=CascadeType.PERSIST)         //many categories can be connected to one user
    private User user;                              //when we save the user, the category gets saved also

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
