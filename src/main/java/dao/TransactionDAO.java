/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import businesslayer.BillingService;
import java.sql.*;
import model.TransactionDTO;

/**
 * DAO class for handling transactional operations.
 * @author tomye
 */
public class TransactionDAO implements ITransactionDao{
    
    private BillingService billingService;
    
    /**
     * Inserts a new transaction record into the db.
     * @param t TransactionDTO object containing transaction details.
     */
    @Override
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
    
    @Override
    public double getUserBalance(int userId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
            SELECT 
                SUM(CASE 
                    WHEN type = 'DEBIT' THEN amonut 
                    WHEN type = 'CREDIT' THEN -amonut 
                END) AS balance
            FROM transactions
            WHERE user_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getDouble("balance");
        }        
        } 
        catch (Exception e) {
            // Prints if error occurs.
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean hasUnpaidBalance(int userId){
        return getUserBalance(userId) > 0;          
    }    
}
