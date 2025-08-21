package com.flipfit.utils;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connection = null;

    public static Connection getConnection() {
        if(connection != null) {
            return connection;
        }
        else{
            try{
                String URL = "jdbc:mysql://localhost:3306/FLIPFIT_SCHEMA";
                String USER = "root";
                String PASSWORD = "juT3$h@nk$m@z3";
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;
        }
    }
}
