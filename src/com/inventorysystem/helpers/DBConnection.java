/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventorysystem.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sohal
 */
public class DBConnection {

    private static final String LOCATION = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "inventory";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "sakshi";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://" + LOCATION + ":" + DB_PORT + "/" +
                DB_NAME, DB_USER, DB_PASSWORD);
    }
    
}
