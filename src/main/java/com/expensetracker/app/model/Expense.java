package com.expensetracker.app.model;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne                  //many of the expenses can go under one category
    private Category category;
    @ManyToOne                  //many expenses can be made by one user
    private User user;
    private BigDecimal amount;
    private String expenseDate;
    private String description;

    public Expense() {

    }

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
                "expenseId=" + id +
                ", category=" + category +
                ", user=" + user +
                ", amount=" + amount +
                ", expenseDate=" + expenseDate +
                ", description='" + description + '\'' +
                '}';
    }
}
