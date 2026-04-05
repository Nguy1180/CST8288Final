/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.StationDTO;

/**
 * DAO class for handling all Station operations.
 * @author tomye
 */
public class StationDAO {
    /**
     * Retrieves all stations from the database.
     * @return List of all Stations
     */
    public List<StationDTO> getAllStations() {
        // List to store station records.
        List<StationDTO> list = new ArrayList<>();
        
        // Establishes connection to the database.
        try (Connection conn = DBConnection.getConnection()) {
            // Gets all stations from query.
            String sql = "SELECT * FROM stations";
            // Executes query and stores result set.
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            // Goes through each row in the result set.
            while (rs.next()) {
                // Creates objects and populates with data.
                StationDTO st = new StationDTO();
                st.setStationID(rs.getInt("station_id"));
                st.setName(rs.getString("name"));
                st.setLocation(rs.getString("location"));
                // Adds to the list.
                list.add(st);
            }
        } catch (Exception e) {
            // Prints if error happens.
            e.printStackTrace();
        }
        // Returns list of all stations.
        return list;
    }
}
