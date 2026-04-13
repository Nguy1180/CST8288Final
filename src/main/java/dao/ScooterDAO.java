/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import businesslayer.service.TransactionService;
import java.sql.*;
import java.util.*;
import dto.RideDTO;
import dto.ScooterDTO;

/**
 * DAO class for handling scooter operations.
 * @author tomye
 */
public class ScooterDAO implements IScooterDao{
    
    private TransactionService transactionService;

    private static final double COST_PER_KM = 1.5;
    private static final double COST_PER_MINUTE = 0.2;

    /**
     * Retrieves all scooters from the database.
     * @return List of objects representing all scooters.
     */
    
    @Override
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
                s.setManufacturer(rs.getString("manufacturer")); // FIXED TYPO
                s.setModel(rs.getString("model"));
                s.setColor(rs.getString("color"));
                s.setBatteryCapacity(rs.getDouble("battery_capacity"));
                s.setCurrentChargeLevel(rs.getDouble("current_charge"));
                s.setStatus(rs.getString("status"));
                s.setStationID(rs.getInt("station_id"));
                s.setSponsorID(rs.getInt("sponsor_id"));
                // Adds to the list.
                list.add(s);
}
        } catch (Exception e) {
            // Prints if an error happens.
            e.printStackTrace();
        } 
        // Returns list of scooters.
        return list;
    }

    private double calculateCost(double distanceKm, long durationMinutes) {
        return (distanceKm * COST_PER_KM) + (durationMinutes * COST_PER_MINUTE);
    }
}
