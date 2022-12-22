package com.expensetracker.app.parameters;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.User;
import org.springframework.util.Assert;

import java.math.BigDecimal;

public class ExpenseCreationParameters {
    private final User user;
    private final Category category;

    private final BigDecimal amount;
    private final String expenseDate;
    private final String description;



    public ExpenseCreationParameters(User user,
                                     Category category,
                                     BigDecimal amount,
                                     String expenseDate,
                                     String description) {

        Assert.notNull(amount, "amount should not be null");
        this.user = new User();
        this.category = new Category();
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;


    }

    public User getUser() {
        return user;
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

}
