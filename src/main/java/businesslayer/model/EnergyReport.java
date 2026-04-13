/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.model;

/**
 * Represents an energy report for a scooter.
 *
 * @author Muanda Junior
 */
public class EnergyReport {

    private int scooterId;
    private double currentChargeLevel;
    private double estimatedTimeToFullCharge;
    private String batteryStatus;

    public EnergyReport() {
    }

    public EnergyReport(int scooterId, double currentChargeLevel, double estimatedTimeToFullCharge, String batteryStatus) {
        this.scooterId = scooterId;
        this.currentChargeLevel = currentChargeLevel;
        this.estimatedTimeToFullCharge = estimatedTimeToFullCharge;
        this.batteryStatus = batteryStatus;
    }

    public int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    public double getCurrentChargeLevel() {
        return currentChargeLevel;
    }

    public void setCurrentChargeLevel(double currentChargeLevel) {
        this.currentChargeLevel = currentChargeLevel;
    }

    public double getEstimatedTimeToFullCharge() {
        return estimatedTimeToFullCharge;
    }

    public void setEstimatedTimeToFullCharge(double estimatedTimeToFullCharge) {
        this.estimatedTimeToFullCharge = estimatedTimeToFullCharge;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    @Override
    public String toString() {
        return "EnergyReport{" +
                "scooterId=" + scooterId +
                ", currentChargeLevel=" + currentChargeLevel +
                ", estimatedTimeToFullCharge=" + estimatedTimeToFullCharge +
                ", batteryStatus='" + batteryStatus + '\'' +
                '}';
    }
}
