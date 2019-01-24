package com.company.Managers;

import com.company.Models.CreatePlayerContainer;


public class PlayerManager {

    public void createPlayer(CreatePlayerContainer playerContainer) {
        playerContainer.setPassword(hashPassword(playerContainer.getPassword()));

    }

    private String hashPassword(String password) {
        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        return password;
    }
}


