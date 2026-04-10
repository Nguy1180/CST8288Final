/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.IMaintenanceDao;
import dao.MaintenanceDAO;

/**
 *
 * @author the_p
 */
public class MaintenanceService {
    private IMaintenanceDao maintenance = null;
    
    public MaintenanceService() {
        maintenance = new MaintenanceDAO();
    }    
}
