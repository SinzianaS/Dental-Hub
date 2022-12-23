package com.expensetracker.app.model;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne                  //many of the expenses can go under one category
    private Category category;
    @ManyToOne
    //@JsonIgnore                //many expenses can be made by one user
    private User user;
    private BigDecimal amount;
    private String expenseDate;
    private String description;
    protected Expense(){
    }

    public Expense(Category category,
                   User user,
                   BigDecimal amount,
                   String expenseDate,
                   String description) {

        this.category = category;
        this.user = user;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
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
                ", amount=" + amount +
                ", expenseDate=" + expenseDate +
                ", description='" + description + '\'' +
                '}';
    }
}
