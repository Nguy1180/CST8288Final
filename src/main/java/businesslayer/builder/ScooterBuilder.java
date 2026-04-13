/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.builder;

import businesslayer.model.Scooter;

/**
 * Builder class used to create Scooter objects step by step.
 *
 * @author Muanda Muanda Junior
 */
public class ScooterBuilder {

    private int scooterId;
    private String vehicleNumber;
    private String make;
    private String model;
    private String color;
    private double batteryCapacity;
    private double currentChargeLevel;
    private double gpsLatitude;
    private double gpsLongitude;
    private String status;
    private int lastStationId;
    private double totalUsageHours;
    private double brakeWearLevel;
    private double tireWearLevel;

    public ScooterBuilder setScooterId(int scooterId) {
        this.scooterId = scooterId;
        return this;
    } 

    public ScooterBuilder setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public ScooterBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public ScooterBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public ScooterBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public ScooterBuilder setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    public ScooterBuilder setCurrentChargeLevel(double currentChargeLevel) {
        this.currentChargeLevel = currentChargeLevel;
        return this;
    }

    public ScooterBuilder setGpsLatitude(double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
        return this;
    }

    public ScooterBuilder setGpsLongitude(double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
        return this;
    }

    public ScooterBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public ScooterBuilder setLastStationId(int lastStationId) {
        this.lastStationId = lastStationId;
        return this;
    }

    public ScooterBuilder setTotalUsageHours(double totalUsageHours) {
        this.totalUsageHours = totalUsageHours;
        return this;
    }

    public ScooterBuilder setBrakeWearLevel(double brakeWearLevel) {
        this.brakeWearLevel = brakeWearLevel;
        return this;
    }

    public ScooterBuilder setTireWearLevel(double tireWearLevel) {
        this.tireWearLevel = tireWearLevel;
        return this;
    }

    /**
     * Builds and returns a Scooter object.
     *
     * @return configured Scooter object
     */
    public Scooter build() {
        return new Scooter(
                scooterId,
                vehicleNumber,
                make,
                model,
                color,
                batteryCapacity,
                currentChargeLevel,
                gpsLatitude,
                gpsLongitude,
                status,
                lastStationId,
                totalUsageHours,
                brakeWearLevel,
                tireWearLevel
        );
    }
}
