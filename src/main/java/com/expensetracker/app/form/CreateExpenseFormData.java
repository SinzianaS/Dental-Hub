package com.expensetracker.app.form;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.parameters.ExpenseCreationParameters;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateExpenseFormData {

    private Category category;

    @NotNull
    private String amount;
    private String expenseDate;
    private String description;

    public ExpenseCreationParameters toParameters() {
        return new ExpenseCreationParameters(
                category, amount, expenseDate, description);
    }

    public Category getCategory() {
        return category;
    }

    public String getAmount() {
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

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

