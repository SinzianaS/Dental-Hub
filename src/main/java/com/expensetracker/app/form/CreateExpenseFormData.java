package com.expensetracker.app.form;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.User;
import com.expensetracker.app.parameters.ExpenseCreationParameters;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class CreateExpenseFormData {

    private User user;
    private Category category;
    @DecimalMin("1")
    @DecimalMax(("100000"))
    private BigDecimal amount;
    @NotEmpty
    @Size(min =1, max =400)
    private String expenseDate;
    @NotEmpty
    @Size(min =1, max =400)
    private String description;

    public ExpenseCreationParameters toParameters() {
        return new ExpenseCreationParameters(
               user, category, amount, expenseDate, description);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CreateExpenseFormData{" +
                "user=" + user +
                ", category=" + category +
                ", amount=" + amount +
                ", expenseDate='" + expenseDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

