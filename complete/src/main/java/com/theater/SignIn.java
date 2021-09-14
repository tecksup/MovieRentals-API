package com.theater;

public class SignIn {

    private final long id;
    private final String username;
    private final String password;

    public SignIn(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
