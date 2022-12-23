package com.expensetracker.app.parameters;

import com.expensetracker.app.model.User;


public class CategoryCreationParameters {
    private final String categoryName;
    private final User user;
    public CategoryCreationParameters(String categoryName, User user) {
           this.categoryName = categoryName;
           this.user = user;
       }
    public String getCategoryName() {
        return categoryName;
    }

    public User getUser() {
        return user;
    }

}
