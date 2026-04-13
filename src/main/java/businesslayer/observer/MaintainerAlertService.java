/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.observer;
import businesslayer.model.Alert;

/**
 * Concrete observer that receives and displays maintenance alerts.
 *
 * @author Muanda Junior
 */
public class MaintainerAlertService implements MaintenanceObserver {

    private String maintainerName;

    public MaintainerAlertService(String maintainerName) {
        this.maintainerName = maintainerName;
    }

    @Override
    public void update(Alert alert) {
        System.out.println("Alert sent to maintainer: " + maintainerName);
        System.out.println("Alert Type: " + alert.getAlertType());
        System.out.println("Message: " + alert.getMessage());
        System.out.println("Scooter ID: " + alert.getScooterId());
        System.out.println("-----------------------------------");
    }
}