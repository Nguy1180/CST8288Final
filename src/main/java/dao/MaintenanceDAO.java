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
public class MaintenanceDAO {
    
    /**
     * Retrieves all maintenance records with the PENDING status.
     * @return List of MaintenanceDTO objects with pending maintenance requests.
     */
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
}