/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.IStationDao;
import dao.StationDAO;

/**
 *
 * @author the_p
 */
public class StationService {
    private IStationDao station = null;
    
    public StationService() {
        station = new StationDAO();
        
    }
    
}
