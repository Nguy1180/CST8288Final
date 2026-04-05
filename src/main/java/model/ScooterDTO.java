/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * DTO of Scooters, containing getters and setters.
 * @author tomye
 */
public class ScooterDTO {
    private int scooterID;
    private String vehicleNumber;
    private String manufactorer;
    private String model;
    private String color;
    private int batteryCapacity;

    // Getters and setters.
    public void setScooterID(int scooterID) {
        this.scooterID = scooterID;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setCurrentCharge(int currentCharge) {
        this.currentCharge = currentCharge;
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
    private int currentCharge;
    private String status;
    private int stationID;
    private int sponsorID;

    public int getScooterID() {
        return scooterID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getCurrentCharge() {
        return currentCharge;
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
}
