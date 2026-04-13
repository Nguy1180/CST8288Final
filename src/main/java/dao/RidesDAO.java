/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author the_p
 */
import java.sql.*;

public class RidesDAO implements IRidesDao{

    // START RIDE
    @Override
    public int startRide(int userId, int scooterId, int stationId){
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO rides (user_id, scooter_id, start_station_id, status) VALUES (?, ?, ?, 'ACTIVE')";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, userId);
            stmt.setInt(2, scooterId);
            stmt.setInt(3, stationId);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            return rs.getInt(1);
        }
        catch(Exception e) {
            e.printStackTrace();
        }      
        return 0;
    }

    // END RIDE
    @Override
    public void endRide(int rideId, int endStationId, double distanceKm) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
            UPDATE rides
            SET end_station_id = ?,
                end_time = CURRENT_TIMESTAMP,
                distance_km = ?,
                status = 'COMPLETED'
            WHERE ride_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, endStationId);
        stmt.setDouble(2, distanceKm);
        stmt.setInt(3, rideId);

        stmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        
    }

    // REQUIRED: time outside station (used for billing)
    @Override
    public long getDurationMinutes(int rideId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
            SELECT TIMESTAMPDIFF(MINUTE, start_time, end_time) AS duration
            FROM rides
            WHERE ride_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, rideId);

        ResultSet rs = stmt.executeQuery();
        rs.next();

        return rs.getLong("duration");
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
