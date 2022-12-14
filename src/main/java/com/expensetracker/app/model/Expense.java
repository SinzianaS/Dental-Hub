package com.expensetracker.app.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long expenseId;
    @ManyToOne                  //many of the expenses can go under one category
    private Category category;
    @ManyToOne                  //many expenses can be made by one user
    private User user;
    private double amount;
    private LocalDate expenseDate;
    private String description;

    public Expense() {

    }

    public Expense(Long expenseId,
                   Category category,
                   User user,
                   double amount,
                   LocalDate expenseDate,
                   String description) {
        this.expenseId = expenseId;
        this.category = category;
        this.user = user;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", category=" + category +
                ", user=" + user +
                ", amount=" + amount +
                ", expenseDate=" + expenseDate +
                ", description='" + description + '\'' +
                '}';
    }
}
