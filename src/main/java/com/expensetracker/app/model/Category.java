package com.expensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int categoryId;
    @NonNull
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)         //many categories can be connected to one user
    private User user;                              //when we save the user, the category gets saved also


    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
