package com.company.Models;

/**
 *
 * Created by Mark on 26/01/2019
 */

// This class is a Container class, it is only used to contain user login credentials to verify a user logging in.
public class UserLoginCredentials {
    private String username, password;

    public UserLoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
