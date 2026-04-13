/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.model;

/**
 * Represents GPS tracking data for a scooter.
 *
 * @author Muanda Junior
 */
public class GPSData {

    private int scooterId;
    private double latitude;
    private double longitude;
    private String timestamp;
    private boolean inTransit;

    public GPSData() {
    }

    public GPSData(int scooterId, double latitude, double longitude, String timestamp, boolean inTransit) {
        this.scooterId = scooterId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.inTransit = inTransit;
    }

    public int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isInTransit() {
        return inTransit;
    }

    public void setInTransit(boolean inTransit) {
        this.inTransit = inTransit;
    }

    @Override
    public String toString() {
        return "GPSData{" +
                "scooterId=" + scooterId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp='" + timestamp + '\'' +
                ", inTransit=" + inTransit +
                '}';
    }
}
