/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.service;

import businesslayer.model.EnergyReport;
import businesslayer.model.Scooter;

/**
 * Service class for monitoring scooter energy usage.
 *
 * @author Muanda Junior
 */
public class EnergyMonitorService {

    /**
     * Generates an energy report for a scooter.
     *
     * @param scooter the scooter being monitored
     * @return EnergyReport with battery details
     */
    public EnergyReport generateEnergyReport(Scooter scooter) {

        double currentCharge = scooter.getCurrentChargeLevel();
        double missingPercentage = 100.0 - currentCharge;

        double chargingRatePerHour = 25.0;
        double estimatedTimeToFullCharge = missingPercentage / chargingRatePerHour;

        String batteryStatus;
        if (currentCharge < 20) {
            batteryStatus = "LOW";
        } else if (currentCharge < 60) {
            batteryStatus = "MEDIUM";
        } else {
            batteryStatus = "GOOD";
        }

        return new EnergyReport(
                scooter.getScooterId(),
                currentCharge,
                estimatedTimeToFullCharge,
                batteryStatus
        );
    }
}
