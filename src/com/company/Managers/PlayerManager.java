package com.company.Managers;

import com.company.DataAccess.DAL;
import com.company.Models.CreatePlayerContainer;




public class PlayerManager {

    public void createPlayer(CreatePlayerContainer playerContainer)  {
        //hash Password
        playerContainer.setPassword(hashPassword(playerContainer.getPassword()));
        DAL.getInstance().insertPlayerIntoDB(playerContainer);

    }

    private String hashPassword(String password) {
        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        return sha256hex;
    }
}


