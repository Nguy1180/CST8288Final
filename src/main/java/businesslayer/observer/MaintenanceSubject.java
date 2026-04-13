/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.observer;

/**
 * Subject interface for maintenance monitoring.
 *
 * @author Muanda Junior
 */
public interface MaintenanceSubject {

    void addObserver(MaintenanceObserver observer);

    void removeObserver(MaintenanceObserver observer);

    void notifyObservers();
}
