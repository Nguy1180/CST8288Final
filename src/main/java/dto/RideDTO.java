/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author the_p
 */
public class RideDTO {
    private int userId;
    private double distanceKm;
    private long durationMinutes;

    public RideDTO(int userId, double distanceKm, long durationMinutes) {
        this.userId = userId;
        this.distanceKm = distanceKm;
        this.durationMinutes = durationMinutes;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public long getDurationMinutes() {
        return durationMinutes;
    }

    public int getUserId() {
        return userId;
    }
    
}
