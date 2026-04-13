/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * DTO of Scooters, containing getters and setters.
 * @author tomye
 */
public class ScooterDTO {

    private int scooterID;
    private String vehicleNumber;
    private String manufacturer;
    private String model;
    private String color;

    private double batteryCapacity;
    private double currentChargeLevel;

    private double gpsLatitude;
    private double gpsLongitude;

    private String status;

    private int stationID;
    private int sponsorID;

    private double totalUsageHours;
    private double brakeWearLevel;
    private double tireWearLevel;

    // Getters and Setters
    
    public int getScooterID() {
        return scooterID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getCurrentChargeLevel() {
        return currentChargeLevel;
    }

    public double getGpsLatitude() {
        return gpsLatitude;
    }

    public double getGpsLongitude() {
        return gpsLongitude;
    }

    public String getStatus() {
        return status;
    }

    public int getStationID() {
        return stationID;
    }

    public int getSponsorID() {
        return sponsorID;
    }

    public double getTotalUsageHours() {
        return totalUsageHours;
    }

    public double getBrakeWearLevel() {
        return brakeWearLevel;
    }

    public double getTireWearLevel() {
        return tireWearLevel;
    }

    public void setScooterID(int scooterID) {
        this.scooterID = scooterID;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setCurrentChargeLevel(double currentChargeLevel) {
        this.currentChargeLevel = currentChargeLevel;
    }

    public void setGpsLatitude(double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public void setGpsLongitude(double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public void setSponsorID(int sponsorID) {
        this.sponsorID = sponsorID;
    }

    public void setTotalUsageHours(double totalUsageHours) {
        this.totalUsageHours = totalUsageHours;
    }

    public void setBrakeWearLevel(double brakeWearLevel) {
        this.brakeWearLevel = brakeWearLevel;
    }

    public void setTireWearLevel(double tireWearLevel) {
        this.tireWearLevel = tireWearLevel;
    }
}
