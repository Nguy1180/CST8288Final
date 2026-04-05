/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.ScooterDTO;

/**
 * DAO class for handling scooter operations.
 * @author tomye
 */
public class ScooterDAO {
    /**
     * Retrieves all scooters from the database.
     * @return List of objects representing all scooters.
     */
    public List<ScooterDTO> getAllScooters() {
        // List to score scooter records.
        List<ScooterDTO> list = new ArrayList<>();
        
        // Establishes database connection.
        try (Connection conn = DBConnection.getConnection()) {
            // Selects from all scooters.
            String sql = "SELECT * FROM scooters";
            // Prepare and execute SQL statement.
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            // Creates an object and populates the database.
            while (rs.next()) {
                ScooterDTO s = new ScooterDTO();
                s.setScooterID(rs.getInt("scooter_id"));
                s.setVehicleNumber(rs.getString("vehicle_number"));
                s.setManufactorer(rs.getString("manufactorer"));
                s.setModel(rs.getString("model"));
                s.setColor(rs.getString("color"));
                // Adds it to the list.
                list.add(s);
            }
        } catch (Exception e) {
            // Prints if an error happens.
            e.printStackTrace();
        } 
        // Returns list of scooters.
        return list;
    }
}
