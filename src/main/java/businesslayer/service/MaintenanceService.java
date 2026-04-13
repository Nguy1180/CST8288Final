/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.service;

import dao.IMaintenanceDao;
import dao.MaintenanceDAO;
import java.util.List;
import dto.MaintenanceDTO;
import businesslayer.model.MaintenanceTask;

/**
 *
 * @author the_p and Junior Muanda Muanda
 */
public class MaintenanceService {
    private IMaintenanceDao maintenance = null;
    
    public MaintenanceService() {
        maintenance = new MaintenanceDAO();
        
    }
    
    public List<MaintenanceDTO> getPendingMaintenance() {
        return maintenance.getPendingMaintenance();
    }
    
    public void reportIssue(int scooterId, String issue) {
        maintenance.reportIssue(scooterId, issue);
    }
    
    public void rewardMaintainer(int userId, int scootersReturned) {
        maintenance.rewardMaintainer(userId, scootersReturned);
    }
    
        /**
     * Schedules a maintenance task.
     *
     * @param task the maintenance task to schedule
     */
    public void scheduleTask(MaintenanceTask task) {
        System.out.println("Maintenance task scheduled:");
        System.out.println(task);
        System.out.println("-----------------------------------");
    }

    /**
     * Marks a maintenance task as completed.
     *
     * @param task the maintenance task to complete
     */
    public void completeTask(MaintenanceTask task) {
        task.setStatus("COMPLETED");
        System.out.println("Maintenance task completed:");
        System.out.println(task);
        System.out.println("-----------------------------------");
    }
}
