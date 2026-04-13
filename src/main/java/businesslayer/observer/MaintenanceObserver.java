/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package businesslayer.observer;

import businesslayer.model.Alert;

/**
 * Observer interface for receiving maintenance alerts.
 *
 * @author Muanda Muanda Junior
 */
public interface MaintenanceObserver {

    void update(Alert alert);
}