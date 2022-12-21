package com.expensetracker.app.form;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.parameters.ExpenseCreationParameters;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateExpenseFormData {
    @NotNull
    @Size(min = 1, max = 400)
    private Category category;

    @NotNull
    private String amount;
    private String expenseDate;
    private String description;

    public ExpenseCreationParameters toParameters() {
        return new ExpenseCreationParameters(
                category, amount, expenseDate, description);
    }
}

