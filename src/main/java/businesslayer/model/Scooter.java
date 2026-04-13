/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.model;

/**
 * Represents an e-scooter in the system.
 *
 * @author Muanda Muanda Junior
 */
public class Scooter {

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

    public Scooter() {
    }

    // Full constructor
    public Scooter(int scooterId, String vehicleNumber, String make, String model, String color,
                   double batteryCapacity, double currentChargeLevel,
                   double gpsLatitude, double gpsLongitude, String status,
                   int lastStationId, double totalUsageHours,
                   double brakeWearLevel, double tireWearLevel) {

        this.scooterId = scooterId;
        this.vehicleNumber = vehicleNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.currentChargeLevel = currentChargeLevel;
        this.gpsLatitude = gpsLatitude;
        this.gpsLongitude = gpsLongitude;
        this.status = status;
        this.lastStationId = lastStationId;
        this.totalUsageHours = totalUsageHours;
        this.brakeWearLevel = brakeWearLevel;
        this.tireWearLevel = tireWearLevel;
    }

    // Getters and Setters
    public int getScooterId() { return scooterId; }
    public void setScooterId(int scooterId) { this.scooterId = scooterId; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getBatteryCapacity() { return batteryCapacity; }
    public void setBatteryCapacity(double batteryCapacity) { this.batteryCapacity = batteryCapacity; }

    public double getCurrentChargeLevel() { return currentChargeLevel; }
    public void setCurrentChargeLevel(double currentChargeLevel) { this.currentChargeLevel = currentChargeLevel; }

    public double getGpsLatitude() { return gpsLatitude; }
    public void setGpsLatitude(double gpsLatitude) { this.gpsLatitude = gpsLatitude; }

    public double getGpsLongitude() { return gpsLongitude; }
    public void setGpsLongitude(double gpsLongitude) { this.gpsLongitude = gpsLongitude; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getLastStationId() { return lastStationId; }
    public void setLastStationId(int lastStationId) { this.lastStationId = lastStationId; }

    public double getTotalUsageHours() { return totalUsageHours; }
    public void setTotalUsageHours(double totalUsageHours) { this.totalUsageHours = totalUsageHours; }

    public double getBrakeWearLevel() { return brakeWearLevel; }
    public void setBrakeWearLevel(double brakeWearLevel) { this.brakeWearLevel = brakeWearLevel; }

    public double getTireWearLevel() { return tireWearLevel; }
    public void setTireWearLevel(double tireWearLevel) { this.tireWearLevel = tireWearLevel; }

    @Override
    public String toString() {
        return "Scooter{" +
                "scooterId=" + scooterId +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", currentChargeLevel=" + currentChargeLevel +
                ", gpsLatitude=" + gpsLatitude +
                ", gpsLongitude=" + gpsLongitude +
                ", status='" + status + '\'' +
                ", lastStationId=" + lastStationId +
                ", totalUsageHours=" + totalUsageHours +
                ", brakeWearLevel=" + brakeWearLevel +
                ", tireWearLevel=" + tireWearLevel +
                '}';
    }

    // ================= BUILDER =================
    public static class Builder {

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

        public Builder setScooterId(int scooterId) {
            this.scooterId = scooterId;
            return this;
        }

        public Builder setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setBatteryCapacity(double batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        public Builder setCurrentChargeLevel(double currentChargeLevel) {
            this.currentChargeLevel = currentChargeLevel;
            return this;
        }

        public Builder setGpsLatitude(double gpsLatitude) {
            this.gpsLatitude = gpsLatitude;
            return this;
        }

        public Builder setGpsLongitude(double gpsLongitude) {
            this.gpsLongitude = gpsLongitude;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setLastStationId(int lastStationId) {
            this.lastStationId = lastStationId;
            return this;
        }

        public Builder setTotalUsageHours(double totalUsageHours) {
            this.totalUsageHours = totalUsageHours;
            return this;
        }

        public Builder setBrakeWearLevel(double brakeWearLevel) {
            this.brakeWearLevel = brakeWearLevel;
            return this;
        }

        public Builder setTireWearLevel(double tireWearLevel) {
            this.tireWearLevel = tireWearLevel;
            return this;
        }

        public Scooter build() {
            Scooter scooter = new Scooter();

            scooter.setScooterId(this.scooterId);
            scooter.setVehicleNumber(this.vehicleNumber);
            scooter.setMake(this.make);
            scooter.setModel(this.model);
            scooter.setColor(this.color);
            scooter.setBatteryCapacity(this.batteryCapacity);
            scooter.setCurrentChargeLevel(this.currentChargeLevel);
            scooter.setGpsLatitude(this.gpsLatitude);
            scooter.setGpsLongitude(this.gpsLongitude);
            scooter.setStatus(this.status);
            scooter.setLastStationId(this.lastStationId);
            scooter.setTotalUsageHours(this.totalUsageHours);
            scooter.setBrakeWearLevel(this.brakeWearLevel);
            scooter.setTireWearLevel(this.tireWearLevel);

            return scooter;
        }
    }
}