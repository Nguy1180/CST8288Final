/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author the_p
 */
public interface IRidesDao {
    int startRide(int userId, int scooterId, int stationId);
    void endRide(int rideId, int endStationId, double distanceKm);
    long getDurationMinutes(int rideId);
}
