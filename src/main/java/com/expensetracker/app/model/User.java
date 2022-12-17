package com.expensetracker.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long userId;
    private String userName;
    private String email;

    public User(long userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public User(Long id, String s, String s1) {
    }

    @Override
    public String toString() {
        return userName ;
    }
}
