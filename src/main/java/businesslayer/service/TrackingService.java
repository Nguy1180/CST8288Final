/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.service;
import businesslayer.model.GPSData;
import businesslayer.model.Scooter;
import java.time.LocalDateTime;

/**
 * Service class for GPS tracking simulation.
 *
 * @author Muanda Junior
 */
public class TrackingService {

    /**
     * Updates the location of a scooter and returns GPS data.
     *
     * @param scooter the scooter being tracked
     * @param latitude new latitude
     * @param longitude new longitude
     * @return GPSData containing updated tracking information
     */
    public GPSData updateLocation(Scooter scooter, double latitude, double longitude) {

        scooter.setGpsLatitude(latitude);
        scooter.setGpsLongitude(longitude);

        boolean inTransit = !isNearStation(latitude, longitude);

        if (inTransit) {
            scooter.setStatus("IN_TRANSIT");
        } else {
            scooter.setStatus("AT_STATION");
        }

        return new GPSData(
                scooter.getScooterId(),
                latitude,
                longitude,
                LocalDateTime.now().toString(),
                inTransit
        );
    }

    /**
     * Simulates whether the scooter is near a charging station.
     *
     * @param latitude latitude
     * @param longitude longitude
     * @return true if near station, false otherwise
     */
    private boolean isNearStation(double latitude, double longitude) {
        double stationLatitude = 45.3490;
        double stationLongitude = -75.7570;
        double threshold = 0.0020;

        return Math.abs(latitude - stationLatitude) < threshold
                && Math.abs(longitude - stationLongitude) < threshold;
    }
}