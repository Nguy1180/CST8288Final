/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.MaintenanceDTO;

/**
 * DAO class for handling Maintenance operations.
 * @author tomye
 */
public class MaintenanceDAO implements IMaintenanceDao{
    
    /**
     * Retrieves all maintenance records with the PENDING status.
     * @return List of MaintenanceDTO objects with pending maintenance requests.
     */
    @Override
    public List<MaintenanceDTO> getPendingMaintenance() {
        // List to store retrieved maintenance records.
        List<MaintenanceDTO> list = new ArrayList<>();
        
        // Establishes connection to the DB.
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to select all pending maintenance records.
            String sql = "SELECT * FROM maintenance WHERE status = 'PENDING'";
            // Executes the query and stores result set.
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            // Goes through each row in the result set.
            while (rs.next()) {
                // Creates an object and populates field in the database.
                MaintenanceDTO m = new MaintenanceDTO();
                m.setMaintenanceID(rs.getInt("maintenance_id"));
                m.setIssue(rs.getString("issue"));
                m.setStatus(rs.getString("status"));
                // Adds object to the list.
                list.add(m);
            }
        } catch (Exception e) {
            // Prints error if it fails.
            e.printStackTrace();
        }
        // Returns list of pending maintenance records.
        return list;
    }
    
    @Override
    public void reportIssue(int scooterId, String issue){
        try (Connection conn = DBConnection.getConnection()) {
        String sql = "INSERT INTO maintenance (scooter_id, issue, status) VALUES (?, ?, 'OPEN')";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, scooterId);
        stmt.setString(2, issue);

        stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void rewardMaintainer(int userId, int scootersReturned) {
        try (Connection conn = DBConnection.getConnection()) {
            double credit = scootersReturned * 2.0; // example rate

    String sql = "INSERT INTO transactions (user_id, amonut, type, description) VALUES (?, ?, 'CREDIT', ?)";

    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, userId);
    stmt.setDouble(2, credit);
    stmt.setString(3, "Maintainer reward for returning scooters");

    stmt.executeUpdate();
            
        }
        catch(Exception e) {
            
        }   
}
}