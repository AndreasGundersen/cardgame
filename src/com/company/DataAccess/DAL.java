package com.company.DataAccess;

import com.company.Connection.MySqlConnection;
import com.company.Models.CreatePlayerContainer;

import java.sql.Connection;
import java.sql.SQLException;

public class DAL {
    private static DAL dal = null;

    private Connection connect() {
        try (Connection connection = MySqlConnection.getConnection()) {
            return connection;
        }
        catch (SQLException e) {

        }

    }



    public void insertPlayerIntoDB(CreatePlayerContainer newPlayer) {

    }

    public static DAL getInstance() {
        if (dal == null)  {
            dal = new DAL();
        }
        return dal;

    }
}
