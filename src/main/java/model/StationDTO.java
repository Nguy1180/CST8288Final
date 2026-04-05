/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * DTO of Station, containing getters and setters.
 * @author tomye
 */
public class StationDTO {
    private int stationID;
    private String name;
    private String location;
    
    // Getters and Setters
    public int getStationID() {
        return stationID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
    
    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
