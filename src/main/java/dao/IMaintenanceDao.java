/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import dto.MaintenanceDTO;

/**
 *
 * @author the_p
 */
public interface IMaintenanceDao {
    
    List<MaintenanceDTO> getPendingMaintenance();
    void reportIssue(int scooterId, String issue);
    void rewardMaintainer(int userId, int scootersReturned);
}
