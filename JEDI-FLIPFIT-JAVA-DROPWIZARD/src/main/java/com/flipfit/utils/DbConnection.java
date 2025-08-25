package com.flipfit.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 *@Author : "Gaurav"
 *@ClassName: "DbConnection"
 *@Exceptions: "java.sql.SQLException, java.io.FileNotFoundException, java.io.IOException"
 *@Version : "1.0"
 *@See : "java.sql.Connection, java.sql.DriverManager, java.util.Properties"
 */
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
                String PASSWORD = "Sumanth@2001";
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;
        }
    }
}




