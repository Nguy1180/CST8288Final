/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.TransactionDTO;

/**
 * DAO class for handling transactional operations.
 * @author tomye
 */
public class TransactionDAO {
    /**
     * Inserts a new transaction record into the db.
     * @param t TransactionDTO object containing transaction details.
     */
    public void addTransaction(TransactionDTO t) {
        // Establishes connection to the DB.
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to insert a new transaction.
             String sql = "INSERT INTO transactions (user_id, amount, type, description) VALUES (?, ?, ?, ?)";
             // Prepares SQL statement.
             PreparedStatement ps = conn.prepareStatement(sql);
             // Sets paraemeter values from the DTO object.
             ps.setInt(1, t.getUserID());
             ps.setDouble(2, t.getAmount());
             ps.setString(3, t.getType());
             ps.setString(4, t.getDescription());
             // Executes insert operation.
             ps.executeUpdate();
            } catch (Exception e) {
                // Prints if error occurs.
                e.printStackTrace();
            }
        }
    }
