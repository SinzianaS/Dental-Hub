package com.expensetracker.app.form;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.User;
import com.expensetracker.app.parameters.ExpenseCreationParameters;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateExpenseFormData {
    private User user;
    private Category category;

    @NotNull
    private BigDecimal amount;
    private String expenseDate;
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
}

