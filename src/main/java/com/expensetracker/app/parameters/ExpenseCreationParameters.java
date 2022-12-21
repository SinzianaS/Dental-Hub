package com.expensetracker.app.parameters;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.User;
import org.springframework.util.Assert;

public class ExpenseCreationParameters {
    private final Category category;

    private final String amount;
    private final String expenseDate;
    private final String description;



    public ExpenseCreationParameters(Category category,
                                     String amount,
                                     String expenseDate,
                                     String description) {
        Assert.notNull(category, "category should not be null");
        Assert.notNull(amount, "amount should not be null");
        this.category = category;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;


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

}
