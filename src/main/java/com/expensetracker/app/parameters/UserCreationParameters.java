package com.expensetracker.app.parameters;

public class UserCreationParameters {
    private final String userName;
    private final String email;

    public UserCreationParameters( String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
}
