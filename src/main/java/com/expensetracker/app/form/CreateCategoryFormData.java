package com.expensetracker.app.form;


import com.expensetracker.app.model.User;
import com.expensetracker.app.parameters.CategoryCreationParameters;
import com.expensetracker.app.parameters.ExpenseCreationParameters;
import lombok.NonNull;


public class CreateCategoryFormData {
    private int categoryId;
    @NonNull
    private String name;

    private User user;

    public CategoryCreationParameters toParameters() {
       return new CategoryCreationParameters(
               categoryId, name, user);
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

