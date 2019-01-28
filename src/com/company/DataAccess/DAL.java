package com.company.DataAccess;


import com.company.Models.CreatePlayerContainer;
import com.company.Models.UserLoginCredentials;

import java.sql.*;


public class DAL {
    private static DAL dal = null;

    /**
     *
     * Created by Mark & Gunder on 25/01/2019
     */
    // Creates a connection to the MySql Database.
    private static Connection getConnection() throws SQLException {

        final String url = "jdbc:mysql://localhost/card_engine_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "";

        Connection connect = null;

        // Gets a connection to the Database with the 3 specified parameters (Url, User and Password)
        connect = DriverManager.getConnection(url, user, password);

        // Returns the connection
        return connect;
    }

    /**
     *
     * Created by Mark & Gunder on 25/01/2019
     */
    // Inserts a new player into the DB with the specified information and returns the result of insertion
    public boolean insertPlayerIntoDB(CreatePlayerContainer newPlayer) {
        boolean inserted = false;
        try {
            // Calls GetConnection which returns a connection.
            Connection conn = getConnection();

            if(conn != null) {
                // Creation of the Sql INSERT Statement
                final String sqlQueryInsert = " insert into users (name, username, email, birthday, password)"
                        + " values (?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                final PreparedStatement preparedStmt = conn.prepareStatement(sqlQueryInsert);
                preparedStmt.setString(1, newPlayer.getName());
                preparedStmt.setString(2, newPlayer.getUsername());
                preparedStmt.setString(3, newPlayer.getEmail());
                preparedStmt.setString(4, newPlayer.getBirthday());
                preparedStmt.setString(5, newPlayer.getPassword());

                // execute the preparedstatement
                preparedStmt.execute();

                // Closes the connection
                conn.close();

                inserted = true;
            }
        }
        // Catches the Duplicate entry exception if a user is trying to use a username there is already taken
        catch (SQLIntegrityConstraintViolationException e) {

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }

    /**
     *
     * Created by Mark on 26/01/2019
     */
    // Performs a check in the Database to verify the users login credentials
    public boolean verifyUserCredentials(UserLoginCredentials userForVerification) {
        // A Verification boolean which is being set to true if the credentials are correct
        boolean verification = false;
        try {
            Connection conn = getConnection();

            if(conn != null) {
                // Creation of sql Check statement
                final String sqlQueryCheck = "SELECT count(*) from users WHERE username = ? AND password = ?";

                // Creation of the mysql check statement
                final PreparedStatement preparedStmt = conn.prepareStatement(sqlQueryCheck);
                preparedStmt.setString(1, userForVerification.getUsername());
                preparedStmt.setString(2, userForVerification.getPassword());

                // The execution of the check statement which returns a count to the ResultSet
                final ResultSet resultSet = preparedStmt.executeQuery();

                // If the ResultSet contains anything it sets the verification boolean to true
                if(resultSet.next()) {
                    final int count = resultSet.getInt(1);
                    if (count != 0) {
                        verification = true;
                    }
                }
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        // Returns the verification boolean
        return verification;
    }

    /**
     *
     * Created by Mark & Gunder on 25/01/2019
     */
    // Makes this Class (DAL) a Singleton!
    public static DAL getInstance() {
        if (dal == null)  {
            dal = new DAL();
        }
        return dal;

    }
}
