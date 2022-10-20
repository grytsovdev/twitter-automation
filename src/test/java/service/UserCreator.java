package service;

import model.User;

public class UserCreator {
    protected static final String USER_NAME = "AutoProfile12";
    protected static final String PASSWORD = "Strong_Password";

    public static User withCredentialsFromProperty() {
        return new User(USER_NAME, PASSWORD);
    }

    public static User withEmptyUsername() {
        return new User("", PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(USER_NAME, "");
    }
}
