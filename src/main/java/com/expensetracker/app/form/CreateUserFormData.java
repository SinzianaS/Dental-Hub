package com.expensetracker.app.form;

import com.expensetracker.app.parameters.ExpenseCreationParameters;
import com.expensetracker.app.parameters.UserCreationParameters;

public class CreateUserFormData {
    private long userId;
    private String userName;
    private String email;

    public UserCreationParameters toParameters() {
        return new UserCreationParameters(
                userId,userName, email);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
