package com.expensetracker.app.model;

import java.util.Date;

public class Expense {

    private Long expenseId;
    private Category category;

    private User user;
    private double amount;
    private Date expenseDate;
    private String description;

    public Expense() {

    }

    public Expense(Long expenseId,
                   Category category,
                   User user,
                   double amount,
                   Date expenseDate,
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

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
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
