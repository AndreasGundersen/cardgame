package com.company.Managers;

import com.company.DataAccess.DAL;
import com.company.Models.CreatePlayerContainer;
import com.company.Models.UserLoginCredentials;

public class PlayerManager {

    /**
     *
     * Created by Mark & Gunder on 25/01/2019
     */
    // Hashes the specified password and sends it to the DAL for DB insertion
    public boolean createPlayer(CreatePlayerContainer playerContainer)  {

        // Takes the specified password, hashes it and sets it as the new password
        playerContainer.setPassword(hashPassword(playerContainer.getPassword()));

        // Gets an instance of the DAL and runs the insertion method with the new player
        return DAL.getInstance().insertPlayerIntoDB(playerContainer);
    }

    /**
     *
     * Created by Mark on 26/01/2019
     */
    // hashes the given password to match up against the hashed password in the database
    public boolean verifyUser(UserLoginCredentials user) {

        // Takes the specified password, hashes it and sets it as the new password
        user.setPassword(hashPassword(user.getPassword()));

        // Gets an instance of the DAL to verify that the username & password matches a user in the DB
        // Then it returns the result of the check (True/False)
        return DAL.getInstance().verifyUserCredentials(user);
    }


    /**
     *
     * Created by Mark & Gunder on 25/01/2019
     */
    // Uses an External Library to hash the given password with a Sha 256 Hex Hash and returns it hashed.
    private String hashPassword(String password) {

        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
    }
}


