package com.company;

import com.company.Managers.PlayerManager;
import com.company.Models.CreatePlayerContainer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        PlayerManager manager = new PlayerManager();
        manager.createPlayer(new CreatePlayerContainer("Test", "usernametest", "emailtest", "2018-02-02", "passwordtest"));
    }
}
