/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.IMaintenanceDao;
import dao.MaintenanceDAO;
import java.util.List;
import model.MaintenanceDTO;

/**
 *
 * @author the_p
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
}
