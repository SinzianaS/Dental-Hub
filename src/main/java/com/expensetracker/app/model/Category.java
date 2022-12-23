package com.expensetracker.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @NonNull
    private String categoryName;
    @ManyToOne(cascade = CascadeType.PERSIST)         //many categories can be connected to one user
    private User user;                              //when we save the user, the category gets saved also

    protected Category(){
    }
    public Category(String categoryName, User user) {

        this.categoryName = categoryName;
        this.user =user;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
