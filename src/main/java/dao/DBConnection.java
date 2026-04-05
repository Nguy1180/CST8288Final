/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Used to establish a connection with the MySQL database.
 * @author tomye
 */
public class DBConnection {
    // Database connection url
    private static final String URL = "jdbc:mysql://localhost:3306/CESC";
    // Database username
    private static final String USER = "cst8288";
    // Database password
    private static final String PASSWORD = "cst8288";
    
    /**
     * Creates and returns a connection to the database.
     * @return Connection object used to interact with the db.
     * @throws Exception if it fails.
     */
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
