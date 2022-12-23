package com.expensetracker.app.form;


import com.expensetracker.app.model.User;
import com.expensetracker.app.parameters.CategoryCreationParameters;
import lombok.NonNull;

import javax.validation.constraints.Size;


public class CreateCategoryFormData {
    @NonNull
    @Size(min =1, max=400)
    private String categoryName;

    private User user;

    public CategoryCreationParameters toParameters() {
        return new CategoryCreationParameters(
                categoryName, user);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public User getUser() {
        return user;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

