package com.expensetracker.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @NonNull
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)         //many categories can be connected to one user
    private User user;                              //when we save the user, the category gets saved also


    public Category(int categoryId, String name, User user) {
        this.categoryId = categoryId;
        this.name = name;
        this.user = new User();
    }

    @Override
    public String toString() {
        return name;
    }
}
