package com.expensetracker.app.parameters;

import com.expensetracker.app.model.User;


public class CategoryCreationParameters {
    private final int categoryId;

    private final String name;

    private final User user;

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public CategoryCreationParameters(int categoryId, String name, User user) {
        this.categoryId = categoryId;
        this.name = name;
        this.user = user;
    }
}
