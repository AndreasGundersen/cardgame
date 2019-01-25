package com.company;

import com.company.Managers.PlayerManager;
import com.company.Models.CreatePlayerContainer;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PlayerManager manager = new PlayerManager();
        manager.createPlayer(new CreatePlayerContainer("Test", "usernametest", "emailtest", "passwordtest", new Date()));
    }
}
