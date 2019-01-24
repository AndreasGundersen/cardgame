package com.company.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnection {


    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost/card_engine_TEST";
        String user = "test1";
        String password = "Start123";

        Connection connect = null;
        connect = DriverManager.getConnection(url, user, password);

        return connect;
    }
}
