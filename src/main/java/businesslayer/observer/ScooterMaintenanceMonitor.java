/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.observer;

import businesslayer.model.Alert;
import businesslayer.model.Scooter;
import java.util.ArrayList;
import java.util.List;

/**
 * Monitors scooter conditions and notifies maintainers when maintenance is needed.
 *
 * @author Muanda Muanda Junior
 */
public class ScooterMaintenanceMonitor implements MaintenanceSubject {

    private List<MaintenanceObserver> observers = new ArrayList<>();
    private Alert currentAlert;

    @Override
    public void addObserver(MaintenanceObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MaintenanceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (MaintenanceObserver observer : observers) {
            observer.update(currentAlert);
        }
    }

    /**
     * Checks scooter conditions and creates alerts when thresholds are exceeded.
     *
     * @param scooter the scooter to inspect
     */
    public void checkScooter(Scooter scooter) {

        if (scooter.getCurrentChargeLevel() < 20) {
            currentAlert = new Alert(
                    scooter.getScooterId(),
                    "Battery level is below 20% for scooter " + scooter.getVehicleNumber(),
                    "LOW_BATTERY"
            );
            notifyObservers();
        }

        if (scooter.getBrakeWearLevel() > 80) {
            currentAlert = new Alert(
                    scooter.getScooterId(),
                    "Brake wear level is above 80% for scooter " + scooter.getVehicleNumber(),
                    "BRAKE_MAINTENANCE"
            );
            notifyObservers();
        }

        if (scooter.getTireWearLevel() > 80) {
            currentAlert = new Alert(
                    scooter.getScooterId(),
                    "Tire wear level is above 80% for scooter " + scooter.getVehicleNumber(),
                    "TIRE_MAINTENANCE"
            );
            notifyObservers();
        }

        if (scooter.getTotalUsageHours() > 100) {
            currentAlert = new Alert(
                    scooter.getScooterId(),
                    "Total usage hours exceeded 100 hours for scooter " + scooter.getVehicleNumber(),
                    "GENERAL_MAINTENANCE"
            );
            notifyObservers();
        }
    }
}
