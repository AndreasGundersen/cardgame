package com.company.Models;


import java.util.Date;

public class CreatePlayerContainer {
    private String name, username, email, password;
    private Date birthday;


    public CreatePlayerContainer(String name, String username, String email, String password, Date birthday) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;

    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
