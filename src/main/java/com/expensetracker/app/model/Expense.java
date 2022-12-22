package com.expensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@Data
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne                  //many of the expenses can go under one category
    private Category category;
    @ManyToOne
    @JsonIgnore                //many expenses can be made by one user
    private User user;
    private BigDecimal amount;
    private String expenseDate;
    private String description;


    public Expense(Long id,
                   Integer categoryId,
                   Long userId,
                   BigDecimal amount,
                   String expenseDate,
                   String description) {
        this.id = id;
        this.category= new Category(categoryId, "");
        this.user = new User(userId, "","");
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;
    }

    public Expense(Category category, BigDecimal amount, String expenseDate, String description) {

    }

    @Override
    public String toString() {
        return "Expense{" +
                ", amount=" + amount +
                ", expenseDate=" + expenseDate +
                ", description='" + description + '\'' +
                '}';
    }
}
