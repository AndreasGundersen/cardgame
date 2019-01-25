package com.company.DataAccess;


import com.company.Models.CreatePlayerContainer;

import java.sql.*;


public class DAL {
    private static DAL dal = null;

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost/card_engine_test";
        String user = "root";
        String password = "";

        Connection connect = null;
        connect = DriverManager.getConnection(url, user, password);

        return connect;
    }



    public void insertPlayerIntoDB(CreatePlayerContainer newPlayer) {
        try {
            Connection connection = getConnection();

            String sqlquery = " insert into users (name, username, email, birthday, password)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(sqlquery);
            preparedStmt.setString (1, newPlayer.getName());
            preparedStmt.setString (2, newPlayer.getUsername());
            preparedStmt.setString   (3, newPlayer.getEmail());
            preparedStmt.setString(4, newPlayer.getBirthday());
            preparedStmt.setString    (5, newPlayer.getPassword());

            // execute the preparedstatement
            preparedStmt.execute();

            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static DAL getInstance() {
        if (dal == null)  {
            dal = new DAL();
        }
        return dal;

    }


}
