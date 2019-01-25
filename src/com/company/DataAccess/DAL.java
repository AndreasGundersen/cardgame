package com.company.DataAccess;


import com.company.Models.CreatePlayerContainer;

import java.sql.*;


public class DAL {
    private static DAL dal = null;

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost/card_engine_TEST";
        String user = "test1";
        String password = "Start123";

        Connection connect = null;
        connect = DriverManager.getConnection(url, user, password);

        return connect;
    }



    public void insertPlayerIntoDB(CreatePlayerContainer newPlayer) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sqlquery = "INSERT INTO users("+newPlayer.getName()+","+newPlayer.getUsername()+","+newPlayer.getEmail()+","+newPlayer.getBirthday()+","+newPlayer.getPassword()+")";
            ResultSet rs = statement.executeQuery(sqlquery);
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
